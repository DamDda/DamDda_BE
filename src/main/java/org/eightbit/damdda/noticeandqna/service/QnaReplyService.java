package org.eightbit.damdda.noticeandqna.service;

import org.eightbit.damdda.noticeandqna.dto.QnaReplyDTO;
import org.springframework.data.domain.Page;

public interface QnaReplyService {

    QnaReplyDTO saveQnaReply(QnaReplyDTO qnaReplyDTO);

    void deleteQnaReply(QnaReplyDTO qnaReplyDTO);

    Page<QnaReplyDTO> getQnaReplies(int page, int size);

    void validateQnaReply(Long memberId, Long id);
}
