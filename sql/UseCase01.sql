CREATE TABLE usecase01 ( 
	testcolumn text[][]
);

CREATE FUNCTION usecase01_get()
RETURNS TABLE
( 
    testcolumn text[][]  
)
AS $$
BEGIN
    RETURN QUERY SELECT
        usecase01.testcolumn
    FROM
        usecase01;

    RETURN;
END;
$$ LANGUAGE plpgsql;

INSERT INTO usecase01 VALUES('{"Use","Case","01"}');
--SELECT * FROM usecase01_get();