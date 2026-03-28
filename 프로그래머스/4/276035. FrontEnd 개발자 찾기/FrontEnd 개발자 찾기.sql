-- 코드를 작성해주세요
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS D
WHERE EXISTS (
        SELECT 1 
        FROM SKILLCODES S 
        WHERE S.CATEGORY = 'Front End' 
        -- 비트 연산 핵심: 개발자 코드와 스킬 코드를 & 연산
        AND (D.SKILL_CODE & S.CODE) > 0
    )
ORDER BY ID ASC