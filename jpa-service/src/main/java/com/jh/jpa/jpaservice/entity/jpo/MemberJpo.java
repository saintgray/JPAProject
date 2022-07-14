package com.jh.jpa.jpaservice.entity.jpo;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */

@Entity
@Table(name = "member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberJpo{

    @Id
    private BigDecimal mIdx;
    @Column(name = "m_email")
    private String mEmail;
    @Column(name = "m_nm")
    private String mNm;
    @Column(name ="m_photo")
    private String mPhoto;
    @Column(name = "m_regdate")
    private Timestamp mRegdate;
    @Column(name = "m_quitdate")
    private Timestamp mQuitdate;
    @Column(name = "m_adyn")
    private String mAdyn;
    @Column(name = "m_blacklist")
    private String mBlacklist;
    @Column(name="loc_idx")
    private String locIdx;
    @Column(name = "tempcode")
    private String tempcode;
}
