package com.springboot.blog.services;

import org.springframework.stereotype.Component;
import com.springboot.blog.payloads.CommentDto;

@Component
public interface CommentService {

	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer commentId);
}
