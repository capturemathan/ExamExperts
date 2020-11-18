CREATE TABLE University (
    universityID varchar(255),
    university varchar(255),
    univDescription varchar(255),
    siteURL varchar(255),
    location varchar(255),
    expectedCutoff varchar(255),
    examID varchar(255),
    countryID varchar(255),
    courseID varchar(255)
	);
    
    INSERT INTO University VALUES('NU','Northern University','Northeastern University (NU or NEU) is a private research university in Boston, Massachusetts, established in 1898. The university offers undergraduate and graduate programs on its main campus in Boston.','https://www.northeastern.edu/','https://goo.gl/maps/cprhmsut4NAZGfuZ7','299','GRE','USA','MS');
    INSERT INTO University VALUES('IIT','Indian Institute of Technology','Indian Institute of Technology  is one of the top universities created to be Centres of Excellence for training, research and development in science, engineering and technology in India. ','https://www.iitsystem.ac.in/','https://goo.gl/maps/1z2PWDgqDuKosfez5','77','GATE','IND','M.Tech');
    INSERT INTO University VALUES('LMU','London Metropolitan University','London Metropolitan University, commonly known as London Met, is a public research university in London, England. The University of North London and London Guildhall University merged in 2002 to create the university','https://www.londonmet.ac.uk/','https://goo.gl/maps/ismJFceFTD1WZX3L9','6','IELTS','UK','MBA');
    INSERT INTO University VALUES('ESC','ESC Clermont Business School','ESC Clermont Business School is a business school located in France, in the city of Clermont-Ferrand. Established in 1919, the school of management is a Grande Ecole that is recognized by The French Ministry of Higher Education and Research.','https://www.esc-clermont.fr/en/','https://g.page/esc-clermont-bs?share','85','TOEFL','FRA','M.Com');
    INSERT INTO University VALUES('SRH','SRH HOCHSCHULE HEIDELBERG','The SRH University of Applied Sciences Heidelberg is a state-recognized private university in Heidelberg.The university opened on October 1, 1969 as a "facility for rehabilitation of people with disabilities in the tertiary education sector".','https://www.hs-fresenius.de/','https://goo.gl/maps/VQCh2jpBGpGs1BTe8','80','TOEFL','GER','MA');
   
   select * from University;