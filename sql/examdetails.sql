CREATE TABLE Exam (
    examID varchar(255),
    exam varchar(255),
    examDescription varchar(255),
    totalMarks varchar(255)
);

INSERT INTO Exam VALUES('GRE','Graduate Record Examination','The Graduate Record Examinations is a standardized test that is an admissions requirement for many graduate schools in the United States and Canada.','340');
INSERT INTO Exam VALUES('GATE','Graduate Aptitude Test in Engineering','The Graduate Aptitude Test in Engineering (GATE) is an examination that primarily tests the comprehensive understanding of various undergraduate subjects in engineering','100');
INSERT INTO Exam VALUES('IELTS','International English Language Testing System','The International English Language Testing System, or IELTS, is an international standardized test of English language proficiency for non-native English language speakers','9');
INSERT INTO Exam VALUES('TOEFL','Test of English as a Foreign Language','Test of English as a Foreign Language is a standardized test to measure the English language ability of non-native speakers wishing to enroll in English-speaking universities','120');

select * from Exam;