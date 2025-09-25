package com.test.Member.service;

import com.test.Member.entity.Member;
import com.test.Member.exception.MemberNotFoundValidCheck;
import com.test.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 멤버에서 찾기 id 없으면 에러 반환
    @Transactional(readOnly = true)
    public Member findMemberIdOrExe(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(() -> MemberNotFoundValidCheck.bussinessException);
    }



}
