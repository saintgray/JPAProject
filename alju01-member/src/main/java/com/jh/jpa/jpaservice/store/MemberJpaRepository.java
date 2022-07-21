package com.jh.jpa.jpaservice.store;

import com.jh.jpa.jpaservice.store.jpo.MemberJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
public interface MemberJpaRepository extends JpaRepository<MemberJpo, BigDecimal> {

    List<MemberJpo> findBymEmailLike(String searched);
}
