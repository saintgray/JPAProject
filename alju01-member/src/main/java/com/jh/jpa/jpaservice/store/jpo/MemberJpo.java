package com.jh.jpa.jpaservice.store.jpo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
@Entity
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
// Rest API 를 통한 Data 를 JSON 으로 응답시 JSON 에 담을 Data의 특성을 정한다
// NON_NULL : NULL 이 아닌 DATA 값만 반환
// NON_EMPTY : 비어있지 않은 DATA 값만 반환 (ex) String 의 경우 "" 문자열일 경우 JSON 에 담지 않는다)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @OneToMany
    private List<PostJpo> posts;

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
