package com.jh.jpa.jpaservice.domain.logic.presentation;

import com.jh.jpa.jpaservice.domain.exception.InvalidParamsException;
import com.jh.jpa.jpaservice.domain.spec.presentation.MemberListService;
import com.jh.jpa.jpaservice.store.MemberJpaRepository;
import com.jh.jpa.jpaservice.store.jpo.MemberJpo;
import com.jh.jpa.jpaservice.store.jpo.PostJpo;
import com.jh.jpa.jpaservice.store.jpo.QMemberJpo;
import com.jh.jpa.jpaservice.store.jpo.QPostJpo;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
@Service
@RequiredArgsConstructor
public class MemberStatusLogic implements MemberListService {
    private final MemberJpaRepository memberJpaRepository;
    private final JPAQueryFactory jpaQueryFactory;

    public List<MemberJpo> getMembers() {

//        List<MemberStatusDTO> results = null;
//        list = this.memberJpaRepository.findAll();
//        if(list!=null && !list.isEmpty()){
//            results = new ArrayList<>();
//            for(MemberJpo jpo : list){
//                MemberStatusDTO dto = new MemberStatusDTO();
//                dto.setSucscribeStatus(jpo.isSubscriber() ? "구독중" : "비구독중");
//                results.add(dto);
//            }
//        }
//        return results;
        return this.memberJpaRepository.findAll();
    }

    public List<MemberJpo> findByMEmailLike(String searched) {
//        return this.memberJpaRepository.findBymEmailLike("%".concat(searched).concat("%"));
        return null;
    }

    @Override
    public Map<String, List<MemberJpo>> getMembers(String groupingBy) throws InvalidParamsException {
        List<MemberJpo> list = this.memberJpaRepository.findAll();
        Map<String, List<MemberJpo>> usersGroup = null;
        if (!ObjectUtils.isEmpty(list)) {
            switch (groupingBy.toLowerCase()) {
                case "location": {
                    usersGroup = list.stream().collect(Collectors.groupingBy(MemberJpo::getLocIdx));
                    break;
                }
                case "subscriber": {
                    usersGroup = list.stream()
                            .collect(Collectors.groupingBy(e ->
                                    "Y".equals(e.getMAdyn()) ?
                                            "subscriber" : "nonSubscriber"));
                    break;
                }
                default: {
                    throw new InvalidParamsException();
                }
            }
        }
        return usersGroup;
    }

    @Override
    public Map<String, List<MemberJpo>> getMembersByQueryDsl(String groupingBy) {

        QMemberJpo member = QMemberJpo.memberJpo;
        QPostJpo post = QPostJpo.postJpo;
//        List<MemberJpo> list =
//            jpaQueryFactory.selectFrom(member)
//                    .where(member.mEmail.like("%saint%"))
//                    .fetch();
        List<Tuple> list =
                jpaQueryFactory.select(member.mEmail,
                                member.locIdx,
                                member.mNm)
//                                post.postNm,
//                                post.postRegdate)
                        .from(member)
//                        .join(post)
//                        .on(post.mIdx.eq(member.mIdx))
                        .fetch();
        System.out.println(list);

        Map<String, List<MemberJpo>> result = null;
//        if(ObjectUtils.isEmpty(list)){
//            if(groupingBy.equalsIgnoreCase("location")){
//                result = list.stream().collect(
//                        Collectors.groupingBy(MemberJpo::getLocIdx));
//            }else{
//                throw new NoSuchElementException();
//            }
//        }

        List<MemberJpo> memberDtoList = new ArrayList<>();
        for (Tuple tuple : list) {
            memberDtoList.add(MemberJpo.builder()
                    .mEmail(tuple.get(member.mEmail))
                    .mNm(tuple.get(member.mNm))
                    .locIdx(tuple.get(member.locIdx))
                    .mBlacklist("")
                    .build());
        }
        result = memberDtoList.stream().collect(Collectors.groupingBy(MemberJpo::getLocIdx));

        return result;
    }
}
