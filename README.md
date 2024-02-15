# Unscramble

유어슈 안드로이드 과제

뒤죽박죽 되어 있는 스펠을 보고 원래 단어를 맞추는 게임

## 목표

YDS 사용해보기

클린 아키텍처 적용해보기

- Step 1. String array resource
- Step 2. Http 클라이언트 라이브러리로 불러오기 (Retrofit2)
- Step 3. 타이머 구현

## 팀원

- Gio [Android]
- Bona [Android]
- Wes [Android]

## Git convention

### Branch

- 개인 개발 브랜치

> feature/{nickname}/{issue-number}-{feature-name}
>
> Ex) feature/wes/1-first-issue


### 사용 방식

- 개인 브랜치 → develop

### Commit

> 1 Action 1 Commit

### Github Commit message template

```
# <타입> : <제목> 형식으로 작성하며 제목은 최대 50글자 정도로만 입력
# 제목 끝에 마침표 금지, 무엇을 했는지 명확하게 작성

################
# 추가 설명을 아랫줄에 작성(생략 가능)

################
# init: 프로젝트 생성
# chore: 자잘한 수정
# docs: README나 WIKI 등의 문서 개정
# feat: 새로운 기능 구현
# fix: 버그, 오류 해결
# refactor: 리팩토링
################
```

### Pull Request

#### PR Title

> [`{label}`#`{issue num}`] `{title}`
>

Ex) [feat#1] first pr

#### PR label

- init: 프로젝트 생성
- chore: 자잘한 수정
- docs: README나 WIKI 등의 문서 개정
- feat: 새로운 기능 구현
- fix: 버그, 오류 해결
- refactor: 리팩토링
- help: Draft PR

#### PR review rule

- 기존 코드 수정 → 해당 코드 오너
- approve 1개 이상 받으면 알아서 merge 하기
- suffix 이모지 추가 Lint
- `.` 끝내기 금지, `~` `!!` 정도로 마무리하기

#### PR template

> 사진 적극 활용 추천
>

```
## Summary
> - 무슨 이유로 코드를 변경했는지

## Describe your changes
> - 관련 스크린샷
> - 변경 또는 추가된 코드

## Issue
> - Issue number

## To reviewers
> - 어떤 위험이나 장애가 발견되었는지
> - 어떤 부분에 리뷰어가 집중하면 좋을지
```

#### PR Merge

- feature → develop : 스쿼시(squash) merge
- develop → main : 일반(with merge commit) merge
- hotfix → main : 일반 merge



## 링크

### [📄노션 링크(컨벤션 정리)](https://www.notion.so/yourssu/Unscramble-3-1477f873b2b8491baa5fffd895810356?pvs=4)

### [🎨피그마 링크](https://www.figma.com/file/XZFGNqNBGFRFTMNFeO0ZHN/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%9D%B8%ED%81%90%EB%B2%A0%EC%9D%B4%ED%8C%85-%EA%B3%BC%EC%A0%9C-Unscramble?type=design&node-id=0%3A1&mode=design&t=RJT2CYopdvzJ0C5p-1)


