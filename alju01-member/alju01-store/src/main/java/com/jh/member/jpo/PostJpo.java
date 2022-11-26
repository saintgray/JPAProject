package com.jh.member.jpo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@Table(name = "post")
@NoArgsConstructor
@Getter
@ToString
public class PostJpo {

    @Id
    @Column(name = "post_idx")
    private BigDecimal postIdx;
    @Column(name = "post_nm")
    private String postNm;
    @Column(name = "post_content")
    private String postContent;
    @Column(name = "post_regdate")
    private Timestamp postRegdate;
    @Column(name = "post_editdate")
    private Timestamp postEditDate;
    @Column(name = "post_deldate")
    private Timestamp postDelDate;
    @Column(name = "cat_idx")
    private BigDecimal categoryIdx;
    @Column(name = "post_rate")
    private BigDecimal postRate;
    @Column(name = "wanted")
    private String wanted;
    @Column(name = "m_idx")
    private BigDecimal mIdx;

}
