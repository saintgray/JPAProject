package com.jh.jpa.jpaservice.store.jpo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */


@Entity
@Table(name = "member")
@NoArgsConstructor
@Getter
public class MemberJpo {

    @Id
    private BigDecimal mIdx;
    @Column(name = "m_email")
    private String mEmail;
    @Column(name = "m_nm")
    private String mNm;
    @Column(name = "m_photo")
    private String mPhoto;
    @Column(name = "m_regdate")
    private Timestamp mRegdate;
    @Column(name = "m_quitdate")
    private Timestamp mQuitdate;
    @Column(name = "m_adyn")
    private String mAdyn;
    @Column(name = "m_blacklist")
    private String mBlacklist;
    @Column(name = "loc_idx")
    private String locIdx;
    @Column(name = "tempcode")
    private String tempcode;



    public boolean isSubscriber(){
        return "Y".equals(this.mAdyn) ? true : false;
    }
//    public String toDomains(MemberJpo jpo){
//        return JsonUtil.toJson(jpo);
//    }
//    public MemberJpo fromDomains(String json){
//        return JsonUtil.fromJson(json, MemberJpo.class);
//    }
}
