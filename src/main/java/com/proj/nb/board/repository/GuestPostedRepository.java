package com.proj.nb.board.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.nb.board.model.Guestposted;

public interface GuestPostedRepository extends JpaRepository<Guestposted,Long>{
	
		List<Guestposted> findAllByGuestname(String guestname);
		Guestposted findByGuestname(String guestname);
}
