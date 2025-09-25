package com.test.Member.controller;

import com.test.Member.dto.JoinDto;
import com.test.Member.entity.Member;
import com.test.Member.service.MemberService;
import com.test.common.exception.BussinessException;
import com.test.utils.api.ApiResponse;
import com.test.utils.api.ApiResponse.CustomBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "회원 API", description = "회원 관련 REST API")
public class MemberRestController {

    private final MemberService memberService;

    /** 회원가입 */
    @Operation(summary = "회원가입", description = "이메일, 비밀번호, 닉네임 등으로 회원가입을 진행합니다.")
    @PostMapping("/signup")
    public ApiResponse<CustomBody<Member>> signup(
            @Parameter(description = "회원가입 정보 DTO") @RequestBody @Valid JoinDto joinDto) {

        try {
            Member member = memberService.signup(joinDto); // signup 수정 필요: Member 반환
            CustomBody<Member> body = new CustomBody<>(true, member, null);
            return new ApiResponse<>(body, HttpStatus.CREATED);
        } catch (BussinessException e) {
            CustomBody<Member> body = new CustomBody<>(false, null, null); // 필요 시 ErrorResponse 확장 가능
            return new ApiResponse<>(body, HttpStatus.BAD_REQUEST);
        }
    }

    /** 프로필 조회 */
    @Operation(summary = "프로필 조회", description = "로그인한 회원의 프로필 정보를 조회합니다.")
    @GetMapping("/profile")
    public ApiResponse<CustomBody<Member>> profile(
            @Parameter(description = "세션에 저장된 로그인 사용자")
            @SessionAttribute(name = "loginUser", required = false) Member loginUser) {

        if (loginUser == null) {
            CustomBody<Member> body = new CustomBody<>(false, null, null);
            return new ApiResponse<>(body, HttpStatus.UNAUTHORIZED);
        }
        CustomBody<Member> body = new CustomBody<>(true, loginUser, null);
        return new ApiResponse<>(body, HttpStatus.OK);
    }
}
