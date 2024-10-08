package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * Represents a Course within the university's scheduling system. Each course
 * has a unique combination of name, title, section, credits, instructor,
 * meeting days, and time.
 * 
 * @author Dania Swelam
 */

public class Course extends Activity {

	/** Course's name. */
	private String name;
	/** Course's section. */
	private String section;
	/** Course's credit hours */
	private int credits;
	/** Course's instructor */
	private String instructorId;
	/** Constant integer for minimum Course name length */
	private static final int MIN_NAME_LENGTH = 5;
	/** Constant integer for maximum Course name length */
	private static final int MAX_NAME_LENGTH = 8;
	/** Constant integer for minimum Course letter count */
	private static final int MIN_LETTER_COUNT = 1;
	/** Constant integer for maximum Course letter count */
	private static final int MAX_LETTER_COUNT = 4;
	/** Constant integer for Course digits count */
	private static final int DIGIT_COUNT = 3;
	/** Constant integer for Course section length */
	private static final int SECTION_LENGTH = 3;
	/** Constant integer for maximum Course credits */
	private static final int MAX_CREDITS = 5;
	/** Constant integer for minimum Course credits */
	private static final int MIN_CREDITS = 1;

	/**
	 * Constructs a Course object with values for all fields.
	 * 
	 * @param name         name of Course
	 * @param title        title of Course
	 * @param section      section of Course
	 * @param credits      credit hours for Course
	 * @param instructorId instructor's unity id
	 * @param meetingDays  meeting days for Course as series of chars
	 * @param startTime    start time for Course
	 * @param endTime      end time for Course
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays,
			int startTime, int endTime) {
		super(title, meetingDays, startTime, endTime);
		setName(name);
		setSection(section);
		setCredits(credits);
		setInstructorId(instructorId);
	}

	/**
	 * Creates a Course with the given name, title, section, credits, instructorId,
	 * and meetingDays for courses that are arranged.
	 * 
	 * @param name         name of Course
	 * @param title        title of Course
	 * @param section      section of Course
	 * @param credits      credit hours for Course
	 * @param instructorId instructor's unity id
	 * @param meetingDays  meeting days for Course as series of chars
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays) {
		this(name, title, section, credits, instructorId, meetingDays, 0, 0);
	}

	/**
	 * Returns the name of a Course
	 * 
	 * @return the name of Course
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the course. The course name must adhere to specific
	 * requirements: - It cannot be null or an empty string. - It must have a length
	 * between 5 and 8 characters (inclusive). - It must contain one space between
	 * letter characters and number characters. - It must start with 1 to 4 letter
	 * characters. - It must end with three digit characters.
	 * 
	 * @param name The name to set for the course.
	 * @throws IllegalArgumentException If the provided name violates any of the
	 *                                  specified requirements.
	 */
	private void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid course name.");
		}
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid course name.");
		}

		int numLetters = 0;
		int numDigits = 0;
		boolean spaceFound = false;

		for (int i = 0; i < name.length(); i++) {
			if (!spaceFound) {
				// Check for letter characters and space
				if (Character.isLetter(name.charAt(i))) {
					numLetters++;
				} else if (name.charAt(i) == ' ') {
					spaceFound = true;
				} else {
					throw new IllegalArgumentException("Invalid course name.");
				}
			} else {
				// Check for digit characters
				if (Character.isDigit(name.charAt(i))) {
					numDigits++;
				} else {
					throw new IllegalArgumentException("Invalid course name.");
				}
			}
		}

		// Check if the number of letters is within the valid range
		if (numLetters < MIN_LETTER_COUNT || numLetters > MAX_LETTER_COUNT) {
			throw new IllegalArgumentException("Invalid course name.");
		}

		// Check if the number of digits is exactly DIGIT_COUNT
		if (numDigits != DIGIT_COUNT) {
			throw new IllegalArgumentException("Invalid course name.");
		}

		// Check if the length of the name is within the valid range
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid course name.");
		}

		// If all checks pass, set the name
		this.name = name;
	}

	/**
	 * Returns the section of a given Course
	 * 
	 * @return the section of Course
	 */
	public String getSection() {
		return section;
	}

	/**
	 * Sets the section of the course.
	 * 
	 * @param section The section to set for the course.
	 * @throws IllegalArgumentException If the provided section is null, or its
	 *                                  length is not equal to SECTION_LENGTH, or it
	 *                                  contains non-digit characters.
	 */
	public void setSection(String section) {
		if (section == null || section.length() != SECTION_LENGTH) {
			throw new IllegalArgumentException("Invalid section.");
		}
		for (int i = 0; i < SECTION_LENGTH; i++) {
			if (!Character.isDigit(section.charAt(i))) {
				throw new IllegalArgumentException("Invalid section.");
			}
		}
		this.section = section;
	}

	/**
	 * Returns the number of credits for a given Course
	 * 
	 * @return the credits of a Course
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Sets the credit hours for the course.
	 * 
	 * @param credits The credit hours to set for the course.
	 * @throws IllegalArgumentException If the provided credits value is outside the
	 *                                  valid range.
	 */
	public void setCredits(int credits) {
		if (credits < MIN_CREDITS || credits > MAX_CREDITS) {
			throw new IllegalArgumentException("Invalid credits.");
		}
		this.credits = credits;
	}

	/**
	 * Returns the instructor ID for a given Course
	 * 
	 * @return the instructorId for given Course
	 */
	public String getInstructorId() {
		return instructorId;
	}

	/**
	 * Sets the instructor ID for the course.
	 * 
	 * @param instructorId The instructor ID to set for the course.
	 * @throws IllegalArgumentException If the provided instructor ID is null or
	 *                                  empty.
	 */
	public void setInstructorId(String instructorId) {
		if (instructorId == null || instructorId.isEmpty()) {
			throw new IllegalArgumentException("Invalid instructor id.");
		}
		this.instructorId = instructorId;
	}

	/**
	 * Generates the hash code value for the Course object.
	 * 
	 * @return The hash code value.
	 **/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credits;
		result = prime * result + getEndTime();
		result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
		result = prime * result + ((getMeetingDays() == null) ? 0 : getMeetingDays().hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + getStartTime();
		result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
		return result;
	}

	/**
	 * Compares this Course object with another object for equality.
	 * 
	 * @param obj The object to compare with.
	 * @return true if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (getEndTime() != other.getEndTime())
			return false;
		if (instructorId == null) {
			if (other.instructorId != null)
				return false;
		} else if (!instructorId.equals(other.instructorId))
			return false;
		if (getMeetingDays() == null) {
			if (other.getMeetingDays() != null)
				return false;
		} else if (!getMeetingDays().equals(other.getMeetingDays()))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (getStartTime() != other.getStartTime())
			return false;
		if (getTitle() == null) {
			if (other.getTitle() != null)
				return false;
		} else if (!getTitle().equals(other.getTitle()))
			return false;
		return true;
	}

	/**
	 * Returns a comma separated value String of all Course fields.
	 * 
	 * @return String representation of Course
	 */
	@Override
	public String toString() {
		if ("A".equals(getMeetingDays())) {
			return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + ","
					+ getMeetingDays();
		}
		return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + "," + getMeetingDays()
				+ "," + getStartTime() + "," + getEndTime();

	}

	/**
	 * Returns an array of length 4 containing the course name, section, title, and
	 * meeting string.
	 * 
	 * @return a String array representing the short version of the display
	 *         information for the course
	 */
	@Override
	public String[] getShortDisplayArray() {
		return new String[] { getName(), getSection(), getTitle(), getMeetingString() };
	}

	/**
	 * Returns an array of length 7 containing the course name, section, title,
	 * credits, instructor ID, meeting string, and an empty string.
	 * 
	 * @return a String array representing the long version of the display
	 *         information for the course
	 */
	@Override
	public String[] getLongDisplayArray() {
		return new String[] { getName(), getSection(), getTitle(), Integer.toString(getCredits()), getInstructorId(),
				getMeetingString(), "" };
	}

	/**
	 * Sets the meeting days and times for the activity.
	 *
	 * @param meetingDays a string representing meeting days
	 * @param startTime   the start time of the activity in military format
	 * @param endTime     the end time of the activity in military format
	 * @throws IllegalArgumentException if meetingDays is null or empty, contains
	 *                                  invalid characters, has duplicate days, or
	 *                                  if arranged meeting has non-zero start or
	 *                                  end time
	 */
	@Override
	public void setMeetingDaysAndTime(String meetingDays, int startTime, int endTime) {
		if ("A".equals(meetingDays)) {
			if (startTime != 0 || endTime != 0) {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}

			super.setMeetingDaysAndTime("A", 0, 0);
		} else {
			int countM = 0, countT = 0, countW = 0, countH = 0, countF = 0;

			for (char day : meetingDays.toCharArray()) {
				switch (day) {
				case 'M':
					countM++;
					break;
				case 'T':
					countT++;
					break;
				case 'W':
					countW++;
					break;
				case 'H':
					countH++;
					break;
				case 'F':
					countF++;
					break;
				default:
					throw new IllegalArgumentException("Invalid meeting days and times.");
				}
			}

			if (countM > 1 || countT > 1 || countW > 1 || countH > 1 || countF > 1) {
				throw new IllegalArgumentException("Invalid meeting days and times.");
			}

			super.setMeetingDaysAndTime(meetingDays, startTime, endTime);
		}
	}

	/**
	 * Checks if activity is a duplicate of course.
	 * 
	 * @param activity Activity that is checked for duplicates.
	 * @return true if the activities are duplicates.
	 */
	@Override
	public boolean isDuplicate(Activity activity) {
		if (activity instanceof Course) {
			Course otherCourse = (Course) activity;
			return this.getName().equals(otherCourse.getName());
		}
		return false;
	}
}