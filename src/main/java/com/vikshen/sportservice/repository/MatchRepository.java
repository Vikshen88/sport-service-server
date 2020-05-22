package com.vikshen.sportservice.repository;

import com.vikshen.sportservice.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Integer> {
}
