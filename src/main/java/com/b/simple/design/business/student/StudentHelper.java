package com.b.simple.design.business.student;

public class StudentHelper {

    public static final int GRADE_B_LOWER_LIMIT = 51;
    public static final int GRADE_B_UPPER_LIMIT = 80;
    public static final int EXTRA_MATH_LIMIT = 10;
    public static final int QUIZ_MATH_EXTRA_LIMIT = 5;

    /* PROBLEM 1 */
    /*
     * You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.
     */
    public boolean isGradeB(int marks, boolean isMaths) {
        // OLD: return isMaths ? marks>=51 && marks<=90 : marks>=51 && marks<=80;

        int extraLimit = isMaths ? EXTRA_MATH_LIMIT : 0;
        int upperLimit = GRADE_B_UPPER_LIMIT + extraLimit;
        return  marks >= GRADE_B_LOWER_LIMIT && marks <= upperLimit;
    }

    /* PROBLEM 2 */
	/*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
	*/

    public String getGrade(int mark, boolean isMaths) {
        /* OLD:
        String grade = "C";

        if (isAGrade(mark, isMaths))
            grade = "A";
        else if (isBGrade(mark, isMaths)) {
            grade = "B";
        }
        return grade;
        */

        int mathExtraLimit = isMaths ? 5 : 0;
        if (mark >= 91 + mathExtraLimit) return "A";

        if (mark >= 51 + mathExtraLimit) return "B";

        return "C";
    }

    private boolean isAGrade(int mark, boolean isMaths) {
        int lowerLimitForAGrade = isMaths ? 95
                : 90;
        return mark > lowerLimitForAGrade;
    }

    private boolean isBGrade(int mark, boolean isMaths) {
        int lowerLimitGradeB = isMaths ? 55
                : 50;
        return mark > lowerLimitGradeB && mark < 90;
    }

    /*  PROBLEM 3
     * You and your Friend are planning to enter a Subject Quiz.
     * However, there is a marks requirement that you should attain to qualify.
     *
     * Return value can be YES, NO or MAYBE.
     *
     * YES If either of you are very good at the subject(has 80 or more marks)
     * However, there is an exception that if either of you is not good in the subject(20 or less marks), it is NO.
     * In all other conditions, return MAYBE.
     *
     * However, the definition for good and not good are 5 marks higher if the subject is Mathematics.
     *
     * marks1 - your marks
     * marks2 - your friends marks
     */

    public String willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {
        /*
        * if ((isMaths ? marks1 <= 25 : marks1 <= 20)
                || (isMaths ? marks2 <= 25 : marks2 <= 20)) return "NO";
        if ((isMaths ? marks1 >= 85 : marks1 >= 80)
                || (isMaths ? marks2 >= 85 : marks2 >= 80)) return "YES";
        return "MAYBE";
        * */
        int mathExtraLimit = isMaths ? QUIZ_MATH_EXTRA_LIMIT : 0;
        if (isNotGood(marks1, mathExtraLimit) || isNotGood(marks2, mathExtraLimit)) return "NO";
        if (isGood(marks1, mathExtraLimit) || isGood(marks2, mathExtraLimit)) return "YES";
        return "MAYBE";
    }

    private boolean isGood(int marks, int mathExtraLimit) {
        return marks >= 80 + mathExtraLimit;
    }

    private boolean isNotGood(int marks, int mathExtraLimit) {
        return marks <= 20 + mathExtraLimit;
    }

}















