package org.eightbit.damdda.noticeandqna.service;

import lombok.RequiredArgsConstructor;
import org.eightbit.damdda.member.domain.Member;
import org.eightbit.damdda.member.service.MemberService;
import org.eightbit.damdda.noticeandqna.domain.QnaQuestion;
import org.eightbit.damdda.noticeandqna.domain.QnaReply;
import org.eightbit.damdda.noticeandqna.dto.QnaReplyDTO;
import org.eightbit.damdda.noticeandqna.repository.QnaReplyRepository;
import org.eightbit.damdda.project.domain.Project;
import org.eightbit.damdda.project.service.ProjectService;
import org.eightbit.damdda.security.util.SecurityContextUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QnaReplyServiceImpl implements QnaReplyService {

    private final QnaReplyRepository qnaReplyRepository;
    private final ModelMapper modelMapper;
    private final MemberService memberService;
    private final QnaQuestionService qnaQuestionService;
    private final ProjectService projectService;


    @Override
    public QnaReplyDTO saveQnaReply(QnaReplyDTO qnaReplyDTO) {
        Long qnaReplyId = qnaReplyDTO.getId();
        Long memberId = SecurityContextUtil.getAuthenticatedMemberId();

        qnaReplyDTO.setMemberId(memberId);

        Member existingMember = memberService.findById(memberId)
                        .orElseThrow(() -> new RuntimeException("Member not found"));

//        QnaQuestion existingQnaQuestion = qnaQuestionService.findById(qnaReplyDTO.getQnaQuestionId());

        qnaReplyDTO.setId(qnaReplyId);

        QnaReply qnaReply = modelMapper.map(qnaReplyDTO, QnaReply.class);

        if(qnaReplyId != null && qnaReplyRepository.existsById(qnaReplyId)) {
            validateQnaReply(memberId, qnaReplyId);
        }

        QnaReply savedQnaReply = qnaReplyRepository.save(qnaReply);

        return modelMapper.map(savedQnaReply, QnaReplyDTO.class);
    }

    @Override
    public void deleteQnaReply(QnaReplyDTO qnaReplyDTO) {

    }

    @Override
    public Page<QnaReplyDTO> getQnaReplies(int page, int size) {
        return null;
    }

    @Override
    public void validateQnaReply(Long memberId, Long id) {

    }
}