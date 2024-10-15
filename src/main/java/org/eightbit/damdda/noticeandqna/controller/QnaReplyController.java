package org.eightbit.damdda.noticeandqna.controller;

import org.eightbit.damdda.noticeandqna.domain.QnaQuestion;
import org.eightbit.damdda.noticeandqna.dto.QnaQuestionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damdda/qna/question")
public class QnaReplyController {

    @PostMapping
    public ResponseEntity<String> registerQna(){
        return null;
    }

    @GetMapping
    public ResponseEntity<String> getQna(){
        return null;
    }

    @DeleteMapping("/{qnaQuestionId}")
    public ResponseEntity<String> deleteQna(@PathVariable("qnaQuestionId") String qnaQuestionId){
        return null;
    }

    @PutMapping("/{qnaQuestionId}")
    public ResponseEntity<String> modifyQna(@RequestBody QnaQuestionDTO qnaQuestionDTO, @PathVariable("qnaQuestionId") String qnaQuestionId){
        return null;
    }
}