package com.ssafy.util.model.service;

import com.ssafy.attraction.model.dao.AttractionRepository;
import com.ssafy.member.model.dao.MemberRepository;
import com.ssafy.post.model.dao.PostRepository;
import com.ssafy.util.model.dto.Statistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UtilService {
    private final MemberRepository memberRepository;
    private final AttractionRepository attractionRepository;
    private final PostRepository postRepository;

    public Statistics getCount() {
        return new Statistics(attractionRepository.getCountOfAttraction(),
                memberRepository.getCountOfMember(), postRepository.getTotalPostCount());
    }
}
