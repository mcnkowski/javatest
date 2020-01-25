WITH Buildings(CountryID, Amount) AS(
SELECT c.CountryID AS CountryID, COUNT(b.BuildingID) AS Amount
FROM XF.City AS c LEFT JOIN XF.Building AS b
ON c.CityID = b.CityID
GROUP BY CountryID)
SELECT XF.Country.Name FROM XF.Country LEFT JOIN Buildings
ON XF.Country.CountryID = Buildings.CountryID
WHERE Buildings.Amount = 0 OR Buldings.Amount IS NULL;