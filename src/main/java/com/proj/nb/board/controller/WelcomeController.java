package com.proj.nb.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proj.nb.board.model.AnalyticsRegistered;
import com.proj.nb.board.model.AnalyticsViews;
import com.proj.nb.board.model.Favorite;
import com.proj.nb.board.model.Guest;
import com.proj.nb.board.model.Guestposted;
import com.proj.nb.board.model.Login;
import com.proj.nb.board.model.PermanentImages;
import com.proj.nb.board.model.ReadUn;
import com.proj.nb.board.model.TemporaryAdmin;
import com.proj.nb.board.model.User;
import com.proj.nb.board.repository.AnalyticsRegisteredRepository;
import com.proj.nb.board.repository.AnalyticsViewsRepository;
import com.proj.nb.board.repository.FavRepository;
import com.proj.nb.board.repository.GuestPostedRepository;
import com.proj.nb.board.repository.GuestRepository;
import com.proj.nb.board.repository.LoginRepository;
import com.proj.nb.board.repository.PermanentRepository;
import com.proj.nb.board.repository.ReadUnRepository;
import com.proj.nb.board.repository.TemporaryRepoistory;
import com.proj.nb.board.repository.UserRepository;
import com.proj.nb.board.service.EncDecService;
import com.proj.nb.board.service.GuestServiceImpl;
import com.proj.nb.board.service.LoginService;



@Controller
public class WelcomeController {
	
	@Autowired
	private UserRepository userrep;
	
	@Autowired
	private LoginRepository lr;
	
	@Autowired
	private TemporaryRepoistory tr;
	
	@Autowired
	private PermanentRepository pr;
	
	@Autowired
	private FavRepository fr;
	
	@Autowired
	private AnalyticsRegisteredRepository arr;
	
	@Autowired
	private AnalyticsViewsRepository avr;
	
	@Autowired
	private GuestRepository gr;
	
	@Autowired
	private ReadUnRepository rur;
	
	@RequestMapping("/")
	public String welcome(){
		return "loginpage";
	}
	
	User n = new User();
	Login loginobject=new Login();
	
	@Autowired
	EncDecService encdec;
	
	SecretKey secretkey;
	@SuppressWarnings("static-access")
	@ResponseBody 
	@GetMapping(path="/add")
	public String addNewSchool(@RequestParam String username
			, @RequestParam String password) {
		
		loginobject.setUsername(username);
		String plainText = password;
	
		try {
			
			//encoding part
			String finalseckey="hg1k1apJ5ghivzyE3UbKTA==";
			byte[] finaldecodedkey = Base64.getDecoder().decode(finalseckey);
			SecretKey finalencseckey=new SecretKeySpec(finaldecodedkey,0,finaldecodedkey.length,"AES");
			byte[] cipherText = encdec.encryptText(plainText, finalencseckey);
			
	        loginobject.setEncpassword(cipherText);
	        lr.save(loginobject);
	        
	    
	        
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
				
		return "Saved";
	}
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userrep.findAll();
	}
	
	
	@Autowired
	LoginService ls;
	
	@GetMapping(path="/login")
	public String willsee(){
		return "loginpage";
	}
	
	
	
	@RequestMapping(value= "/welcome",method = RequestMethod.POST)
	//@ResponseBody
	//String
	//List<PermanentImages>
	//List<ReadUn>
	public String logincred(HttpServletRequest request,HttpServletResponse response,ModelMap model,@RequestParam("username")String username1,@RequestParam("password")String password1){

		
		
		
		model.addAttribute("username1",username1);
		model.addAttribute("password1",password1);
		
		List<PermanentImages> imagejsonpi=pr.findAll();
		List<PermanentImages> imagejsonpi1=pr.findAllByCategory(1);
		List<PermanentImages> imagejsonpi2=pr.findAllByCategory(2);
		List<PermanentImages> imagejsonpi3=pr.findAllByCategory(3);
		List<ReadUn> readuninfo=rur.findAll();
		
		
		
		
			
			
			
			//String encodedkey= Base64.getEncoder().encodeToString(secretkey.getEncoded());
			String encodedkey="hg1k1apJ5ghivzyE3UbKTA==";
			byte[] decodedkey = Base64.getDecoder().decode(encodedkey);
			SecretKey originalkey = new SecretKeySpec(decodedkey,0,decodedkey.length,"AES");
			
			byte[] byteciphertext=lr.findByUsername(username1).getEncpassword();
		
			
			
				String password2;
				try {
					password2 = encdec.decryptText(byteciphertext, originalkey);
					
					if(ls.authpass(password1, password2)){			
						model.addAttribute("imagejsonpi1",imagejsonpi1);
						model.addAttribute("imagejsonpi2", imagejsonpi2);
						model.addAttribute("imagejsonpi3", imagejsonpi3);
						
						model.addAttribute("readuninfo", readuninfo);
						
						
						HttpSession session= request.getSession(true);
						
						//just taking username
						session.setAttribute("currentuser", username1);
						
						
						
						
						List<ReadUn> readundetails=rur.findAllByUsername(username1);
						model.addAttribute("readundetails",readundetails);
						
						
					//	return imagejsonpi;
						return "welcomehome";
					//	return readuninfo;
				
					}
					
					
					
						return "loginpage";
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
						return "loginpage";
			
			
	}
	
	
	@RequestMapping("/home")
	public String home(ModelMap model){
		
		List<PermanentImages> imagejsonpi=pr.findAll();
		List<PermanentImages> imagejsonpi1=pr.findAllByCategory(1);
		List<PermanentImages> imagejsonpi2=pr.findAllByCategory(2);
		List<PermanentImages> imagejsonpi3=pr.findAllByCategory(3);
		
		model.addAttribute("imagejsonpi1",imagejsonpi1);
		model.addAttribute("imagejsonpi2", imagejsonpi2);
		model.addAttribute("imagejsonpi3", imagejsonpi3);
		
		
		return "welcomehome";
	}
	
	private static String UPLOADED_FOLDER = "C://Users//Sankeerth Jagini//workspace//NoticeBoard//src//main//webapp//images//";
	
	
//	@RequestMapping(value="/welcomehome", method = RequestMethod.POST)
	@RequestMapping(value="/upload", method = RequestMethod.POST)
//	@ResponseBody
	//String
	//List<TemporaryAdmin>
	public String singlefileupload(HttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes,@RequestParam("comment")String description,ModelMap model,@RequestParam("gender")String buttonornot){
		
		HttpSession session= request.getSession(true);
		String username = session.getAttribute("currentuser").toString();
		
		
		if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:upload";
          //  return null;
            
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
           // byte[] bytes1 = file1.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            
            
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "'");
             
            TemporaryAdmin ta = new TemporaryAdmin();
            ta.setName(file.getOriginalFilename());
            ta.setDescription(description);
            ta.setButton(buttonornot);
            tr.save(ta);
            
             
      //      return adminlist;    
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
        
        return "redirect:/home";
		
	}
	
	
		
	
	
	@RequestMapping("/admin")
//	@ResponseBody
	//String
	//List<TemporaryAdmin>
	public String admin(ModelMap model){
		
		List<TemporaryAdmin> imagejson = tr.findAll();//from temp database we are making json data
	
	
		String username1="ballu";
		model.addAttribute("username1",username1);
		
		model.addAttribute("imagejson",imagejson);
		
	//	return imagejson;
	    return "admin" ;   
	    
	}
	

	
	
	//@RequestMapping("/approve?imagename={imagename}")
	@RequestMapping(value="/approve",method=RequestMethod.GET)
	//,@RequestParam("description")String description
	public String approve(HttpServletRequest request,HttpServletResponse response,ModelMap model,@RequestParam("imagename1")String imagename,@RequestParam("description")String description,@RequestParam("category")Integer category){
		
		
		if(category==null)category=1;
		System.out.println("entered in approve controller");
		
		//saving it in permanent database
		PermanentImages pi = new PermanentImages();
		pi.setName(imagename);
		pi.setCategory(category);
		//added on 14-08-2017 on 2:07pm
		pi.setButton(tr.findByName(imagename).getButton());
		
		
	
		pr.save(pi);
		pr.findByImagename(imagename).setLikes(0);
		pr.findByImagename(imagename).setDescription(description);
		
		HttpSession session= request.getSession(true);
		
		//just taking username
		String username = session.getAttribute("currentuser").toString();
		
		
		ReadUn ru=new ReadUn();
		ru.setImagename(imagename);
		ru.setUsername(username);
		ru.setReadun(0);
		rur.save(ru);
		
		
		
		AnalyticsViews av=new AnalyticsViews();
		av.setUsername(username);
		av.setImagename(imagename);
		av.setViewscount(0);
		av.setUniqueviews(0);
		avr.save(av);
		
		
		
		if(gr.findByUsername(username)!=null){
			
			Guestposted gp=new Guestposted();
			gp.setGuestname(username);
			gp.setImagename(imagename);
			gp.setDescription(description);
			gpr.save(gp);
			
		}
			
		
		
		
		tr.deleteAllByName(imagename);
		
		//after deleting we ll again send new json
		List<TemporaryAdmin> imagejson = tr.findAll();
		model.addAttribute("imagejson", imagejson);
		
		return "redirect:admin";
		
	}
	
	
	
	@RequestMapping("/disapprove")
	public String del(@RequestParam("imagename1")String imagename, ModelMap model ){
		
		//now we have to delete it from temporary database
			File file= new File(UPLOADED_FOLDER + imagename);
			
			
			if(file.delete())
	    		System.out.println(imagename + " is deleted!");
		
		
		
    	
    	//deleting from temporary database using imagename
    	tr.deleteAllByName(imagename);
    	
    	
    	rur.deleteAllByImagename(imagename);
    	//after deleting we ll again send new json
    	List<TemporaryAdmin> imagejson = tr.findAll();
    	model.addAttribute("imagejson", imagejson);
    	
    	
    	return "redirect:admin";
		
	}
	
	Integer x=0;
	@RequestMapping("/like")
//	@ResponseBody
	public String imagelikes(ModelMap model,@RequestParam("imagename")String imagename){
		
		
	
		Integer imagelikes;
		
		//getting likes till now present for that particular imagename
		imagelikes=pr.findByImagename(imagename).getLikes();
		
		Integer cat=pr.findByImagename(imagename).getCategory();
		imagelikes+=1;
		
		
		//setting incremented imagelikes adn saving it back
		PermanentImages pi=pr.findByImagename(imagename);
		pi.setLikes(imagelikes);
		pi.setCategory(cat);
		pr.save(pi);
		model.addAttribute("imagelikes", imagelikes);
		
		
	  	List<PermanentImages> imagejsonpi=pr.findAll();
	  	List<PermanentImages> imagejsonpi1=pr.findAllByCategory(1);
	  	List<PermanentImages> imagejsonpi2=pr.findAllByCategory(2);
	  	List<PermanentImages> imagejsonpi3=pr.findAllByCategory(3);
		model.addAttribute("imagejsonpi1",imagejsonpi1);
		model.addAttribute("imagejsonpi2",imagejsonpi2);
		model.addAttribute("imagejsonpi3",imagejsonpi3);
		
		
	
	return "welcomehome";
	
	}
	
	
	@RequestMapping("/uploadstatus")
	public String uploadstatus(){
		return "uploadstatus";
	}
	
	
	@RequestMapping("/favsave")
	public String fav(ModelMap model,HttpServletRequest request,HttpServletResponse response,@RequestParam("imagename") String imagename){
		
		//saving favorites
		HttpSession session=request.getSession(true);
		String username = session.getAttribute("currentuser").toString();
		Favorite fa=new Favorite();
		fa.setImages(imagename);
		fa.setUsername(username);
		fr.save(fa);
	
		List<PermanentImages> imagejsonpi=pr.findAll();
		
		List<PermanentImages> imagejsonpi1=pr.findAllByCategory(1);
		List<PermanentImages> imagejsonpi2=pr.findAllByCategory(2);
		List<PermanentImages> imagejsonpi3=pr.findAllByCategory(3);
		
		model.addAttribute("imagejsonpi",imagejsonpi);
		model.addAttribute("imagejsonpi1",imagejsonpi1);
		model.addAttribute("imagejsonpi2",imagejsonpi2);
		model.addAttribute("imagejsonpi3",imagejsonpi3);
	
		return "welcomehome";
	}
	
	
	@RequestMapping("/favshow")
//	@ResponseBody
	//String
	//List<Favorite>
	public String favshow(ModelMap model,HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session=request.getSession(true);
		String username = session.getAttribute("currentuser").toString();
		
		List<Favorite> favlist=fr.findAllByUsername(username);
		
		model.addAttribute("favlist", favlist);
		
	//	return favlist;
		return "fav";
	}
	
	@RequestMapping("/favdel")
	public String favdel(ModelMap model,HttpServletRequest request,HttpServletResponse response,@RequestParam("imagename") String imagename){
		
		HttpSession session=request.getSession(true);
		String username = session.getAttribute("currentuser").toString();
	
		fr.deleteByUsernameAndImages(username, imagename);
		
		List<Favorite> favlist=fr.findAllByUsername(username);
		model.addAttribute("favlist", favlist);
		return "fav";
	}
	
	@Autowired
	GuestServiceImpl gsi;
	
	
	@RequestMapping(value="/guest")
	public String guest(){
		return "guest";
	}
	
	@Autowired
	GuestPostedRepository gpr;
	
	@RequestMapping(value="/guestlogin", method=RequestMethod.POST)
	//@ResponseBody
	//String
	//List<Guestposted>
	public String guestlogin(HttpServletRequest request,HttpServletResponse response,ModelMap model,@RequestParam("emailid")String emailid,@RequestParam("password")String password){
		
		List<Guestposted> imagejsonpi= gpr.findAllByGuestname(emailid);
		
		HttpSession session= request.getSession(true);
		
		//just taking username
		session.setAttribute("currentuser", emailid);
		
		if(gsi.authpassword(emailid, password)){
			
			model.addAttribute("imagejsonpi", imagejsonpi);
		//	return imagejsonpi;
			return "guestform";
		}
		else{
		//	return imagejsonpi;
			return "guest";
		}
		
	}
	
	
	@RequestMapping(value="/guestregistration")
	public String guestregistration(
			@RequestParam("emailid")String emailid,@RequestParam("newpassword")String newpassword,@RequestParam("phonenumber")String phonenumber){
		
		Guest guest=new Guest();
		guest.setPassword(newpassword);
		guest.setPhonenumber(phonenumber);
		guest.setUsername(emailid);
		if(gsi.isTupleExist(guest)){
			System.out.println("error page should be displayed...user already exists");
		}
		else{
			gsi.saveDetails(guest);
		}
		
		return "guestform";
	}
	
	@RequestMapping(value="/guestupload",method=RequestMethod.POST)
	public String guestupload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes,@RequestParam("comment")String description,ModelMap model){
			
		if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:guestupload";
         
            
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
           // byte[] bytes1 = file1.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            
            
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "'");
		
            TemporaryAdmin ta = new TemporaryAdmin();
            ta.setName(file.getOriginalFilename());
            ta.setDescription(description);
            tr.save(ta);
              
        } catch (IOException e) {
            e.printStackTrace();
        }
			return "uploadstatus";
        
	}
	
	
	@RequestMapping("/join")
	public String join(ModelMap model,HttpServletRequest request,HttpServletResponse response,@RequestParam("imagename")String imagename){
		
		/*
		@Autowired
		private AnalyticsRegistered analyticsreg;*/

		AnalyticsRegistered analyticsreg=new AnalyticsRegistered();
		
		HttpSession session=request.getSession(true);
		String username = session.getAttribute("currentuser").toString();
		
		analyticsreg.setImagename(imagename);
		analyticsreg.setUsername(username);
		arr.save(analyticsreg);
		
		List<PermanentImages> imagejsonpi=pr.findAll();
		model.addAttribute("imagejsonpi",imagejsonpi);
		
		
		List<PermanentImages> imagejsonpi1=pr.findAllByCategory(1);
		List<PermanentImages> imagejsonpi2=pr.findAllByCategory(2);
		List<PermanentImages> imagejsonpi3=pr.findAllByCategory(3);
		
		model.addAttribute("imagejsonpi",imagejsonpi);
		model.addAttribute("imagejsonpi1",imagejsonpi1);
		model.addAttribute("imagejsonpi2",imagejsonpi2);
		model.addAttribute("imagejsonpi3",imagejsonpi3);
		
		
		return "welcomehome";
	}
	
	@RequestMapping("/description")
	public String description(HttpServletRequest request,HttpServletResponse response,ModelMap model,@RequestParam("imagename")String imagename){
		
		model.addAttribute("imagename", imagename);
		String description= pr.findByImagename(imagename).getDescription();
		String buttonornot= pr.findByImagename(imagename).getButton();
		model.addAttribute("buttonornot",buttonornot);
		model.addAttribute("description", description);
		
		HttpSession session= request.getSession(true);
		//just taking username
		String username = session.getAttribute("currentuser").toString();
		
		
		if(rur.findByUsernameAndImagename(username, imagename)==null)
		{
			ReadUn ru=new ReadUn();
			ru.setImagename(imagename);
			ru.setUsername(username);
			ru.setReadun(0);
			rur.save(ru);
			
		
		}
		if(rur.findByUsernameAndImagename(username, imagename).getReadun().equals(0)){
			AnalyticsViews analyviews1=avr.findByImagename(imagename);
			analyviews1.setUniqueviews(analyviews1.getUniqueviews()+1);
			
		}
		
		ReadUn readuntuple=rur.findByUsernameAndImagename(username,imagename);
		readuntuple.setReadun(1);
		rur.save(readuntuple);
		
		AnalyticsViews analyviews=avr.findByImagename(imagename);
		analyviews.setViewscount(analyviews.getViewscount()+1);
		avr.save(analyviews);
		
		
		
		return "description";
	}
	
	
	@RequestMapping("/analytics")
	public String analytics(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		HttpSession session=request.getSession(true);
		String username = session.getAttribute("currentuser").toString();
	//	String username = "admin";
		List<AnalyticsViews> analyticsjson = avr.findAllByUsername(username);
		model.addAttribute("analyticsjson", analyticsjson);
		
		
		return "analytics";
	}
	
	@RequestMapping("/analyticsdetails")
	public String analyticsdetials(ModelMap model,@RequestParam("imagename")String imagename,@RequestParam("username")String username){
		
		Integer uniqueviews=avr.findByUsernameAndImagename(username, imagename).getUniqueviews();
		Integer viewcount= avr.findByUsernameAndImagename(username, imagename).getViewscount();
		List<AnalyticsRegistered>registered = arr.findByImagename(imagename);
		model.addAttribute("uniqueviews",uniqueviews);
		model.addAttribute("viewcount", viewcount);
		model.addAttribute("registered", registered);
		
		return  "analyticsdetails";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().invalidate();
       // response.sendRedirect( "/");
		return "loginpage";
	}
	}
