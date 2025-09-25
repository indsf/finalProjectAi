package com.test.post.controller;

import com.test.Member.entity.DisabilityType;
import com.test.auth.resolver.MemberTokenId;
import com.test.common.annotation.AllowAnonymous;
import com.test.post.Entity.AssistanceType;
import com.test.post.Entity.PostType;
import com.test.post.dto.PostEnumResDto;
import com.test.post.dto.PostReqDto;
import com.test.post.dto.PostUpdateReqDto;
import com.test.post.service.PostService;
import com.test.utils.api.ApiResponse;
import com.test.utils.api.ApiResponseGenerator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // RespApi가 요청 처리 기능처리
@RequiredArgsConstructor // Notnull final 생성자 자동생성
@RequestMapping("api/posts")
@Tag(name = "게시글 API", description = "게시글 관련 API") // swagger 묶음
public class PostController {

    private final PostService postService;



    @Operation(summary = "게시글 생성", description = "게시글을 생성합니다.")
    @PostMapping
    public ApiResponse<ApiResponse.CustomBody<Long>> createPost(
            @Valid @RequestBody PostReqDto postReqDto
    ) {
        Long createdPostId = postService.createPost(postReqDto, postReqDto.memberId());
        return ApiResponseGenerator.success(createdPostId, HttpStatus.CREATED);
    }

    @Operation(summary = "게시글 생성을 위한 열거형 정보들 제공", description = "게시글 생성을 위한 열거형 정보들을 제공합니다.")
    @GetMapping("/enums")
    public ApiResponse<ApiResponse.CustomBody<PostEnumResDto>> getPostEnums() {
        PostEnumResDto postEnums = postService.getPostEnums();
        return ApiResponseGenerator.success(postEnums, HttpStatus.OK);
    }





}
