SELECT 
    CASE 
        -- Python을 가졌으면서 Front End 스킬도 있는 경우
        WHEN MAX(IF(NAME = 'Python', 1, 0)) = 1 
             AND MAX(IF(CATEGORY = 'Front End', 1, 0)) = 1 THEN 'A'
        -- C#을 가진 경우
        WHEN MAX(IF(NAME = 'C#', 1, 0)) = 1 THEN 'B'
        -- 그 외 Front End 스킬이 하나라도 있는 경우
        WHEN MAX(IF(CATEGORY = 'Front End', 1, 0)) = 1 THEN 'C'
    END AS GRADE,
    ID, 
    EMAIL
FROM DEVELOPERS D
JOIN SKILLCODES S ON (D.SKILL_CODE & S.CODE) > 0
GROUP BY ID, EMAIL
-- GRADE가 있는 사람만 필터링 (HAVING은 그룹화 이후 조건)
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID;
