package com.jh.jpa.shareutil.entity.vo;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberStatusDTO {
    

    private BigDecimal mIdx;
    private String mEmail;
    private String mNm;
    private String mPhoto;
    private Timestamp mRegdate;
    private Timestamp mQuitdate;
    private String mAdyn;
    private String mBlacklist;
    private String locIdx;
    private String tempcode;
    private String sucscribeStatus;

}
