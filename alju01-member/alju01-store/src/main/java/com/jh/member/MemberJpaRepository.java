package com.jh.member;

import com.jh.member.jpo.MemberJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
public interface MemberJpaRepository extends JpaRepository<MemberJpo, BigDecimal> {

    List<MemberJpo> findByUsrEmailLike(String searched);
}
