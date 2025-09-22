package com.test.Member.entity;

import com.test.common.persistance.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String password;
    private String name;

    private String nickname;

    @Column(name = "profile_image")
    private String profileImageUrl;

    private String email;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'없음'")
    private DisabilityType disabilityType;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'USER'")
    private Role role;

    @Builder
    public Member(String name, String nickname, String profileImageUrl, String email,
                  Integer age, DisabilityType disabilityType, Gender gender,
                  Role role, String password) {
        this.name = name;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
        this.email = email;
        this.age = age;
        this.disabilityType = disabilityType;
        this.gender = gender;
        this.role = role;
        this.password = password;
    }
    public void updateMember(String nickname,String disabilityType){
        this.nickname = nickname;
        this.disabilityType = DisabilityType.disFromValue(disabilityType);
    }
}
