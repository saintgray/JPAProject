package com.jh.member.jpo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.member.jpo.key.MemberJpoKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
@Entity(name = "member")
@Table(name = "member")
@IdClass(MemberJpoKey.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MemberJpo {


    @Id
    @Column(name = "m_idx")
    private BigDecimal idx;
    @Column(name = "m_email")
    private String usrEmail;
    @Column(name = "m_nm")
    private String usrNm;
    @Column(name = "m_photo", updatable = false)
    private String usrPhoto;
    @Column(name = "m_regdate",updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp usrRegDtae;
    @Column(name = "m_quitdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp mQuitdate;
    @Column(name = "m_adyn")
    private String mAdyn;
    @Column(name = "m_blacklist")
    private String mBlacklist;
    @Column(name = "loc_idx")
    private String locIdx;
    @Column(name = "tempcode")
    private String tempcode;

    //    @OneToMany
//    @JoinColumn(name ="m_idx")
//    private List<PostJpo> posts;

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
