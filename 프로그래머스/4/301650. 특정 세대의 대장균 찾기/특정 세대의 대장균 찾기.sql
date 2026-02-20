SELECT f.ID
FROM ECOLI_DATA f
JOIN ECOLI_DATA s ON f.PARENT_ID = s.ID    -- 3세대와 2세대를 연결
JOIN ECOLI_DATA t ON s.PARENT_ID = t.ID    -- 2세대와 1세대를 연결
WHERE t.PARENT_ID IS NULL                  -- 1세대는 부모가 없어야 함
ORDER BY f.ID ASC;