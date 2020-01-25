SELECT co.CountryID, co.Name
FROM XF.Country AS co LEFT JOIN XF.City AS ci
ON co.CountryID = ci.CountryID
GROUP BY co.CountryID, co.Name
HAVING SUM(ci.Population)>400;