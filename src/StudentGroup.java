import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 *
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	private int len;

	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];

	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index)throws IllegalArgumentException  {
		// Add your implementation here
		students[index].setId(student.getId());
		students[index].setFullName(student.getFullName());
		students[index].setBirthDate(student.getBirthDate());
		students[index].setAvgMark(student.getAvgMark());

	}

	@Override
	public void addFirst(Student student)throws IllegalArgumentException  {
		// Add your implementation here
		for(int i=len-1;i>=0;i--)
        {
            students[i+1].setId(students[i].getId());
            students[i+1].setFullName(students[i].getFullName());
            students[i+1].setBirthDate(students[i].getBirthDate());
            students[i+1].setAvgMark(students[i].getAvgMark());
        }
            students[0].setId(student.getId());
            students[0].setFullName(student.getFullName());
            students[0].setBirthDate(student.getBirthDate());
            students[0].setAvgMark(student.getAvgMark());
            len++;
	}

	@Override
	public void addLast(Student student)throws IllegalArgumentException  {
		// Add your implementation here
            students[len].setId(student.getId());
            students[len].setFullName(student.getFullName());
            students[len].setBirthDate(student.getBirthDate());
            students[len].setAvgMark(student.getAvgMark());
            len++;
	}

	@Override
	public void add(Student student, int index)throws IllegalArgumentException  {
		// Add your implementation here
		for(int i=len-1;i>=index;i--)
        {
            students[i+1].setId(students[i].getId());
            students[i+1].setFullName(students[i].getFullName());
            students[i+1].setBirthDate(students[i].getBirthDate());
            students[i+1].setAvgMark(students[i].getAvgMark());
        }
            students[index].setId(student.getId());
            students[index].setFullName(student.getFullName());
            students[index].setBirthDate(student.getBirthDate());
            students[index].setAvgMark(student.getAvgMark());
            len++;
	}

	@Override
	public void remove(int index)throws IllegalArgumentException  {
		// Add your implementation here
        for(int i=index;i<len;i++)
        {
            students[i].setId(students[i+1].getId());
            students[i].setFullName(students[i+1].getFullName());
            students[i].setBirthDate(students[i+1].getBirthDate());
            students[i].setAvgMark(students[i+1].getAvgMark());
        }
        len--;
	}

	@Override
	public void remove(Student student)throws IllegalArgumentException  {
		// Add your implementation here
		for(int i=0;i<len;i++)
        {
            if(students[i].compareTo(student)==0)
                remove(i);
        }
	}

	@Override
	public void removeFromIndex(int index)throws IllegalArgumentException  {
		// Add your implementation here
		for(int i=index;i<len;i++)
        {
            remove(i);
        }
	}

	@Override
	public void removeFromElement(Student student)throws IllegalArgumentException  {
		// Add your implementation here
		for(int i=0;i<len;i++)
        {
            if(students[i].compareTo(student)==0)
                removeFromIndex(i);
        }
	}

	@Override
	public void removeToIndex(int index)throws IllegalArgumentException  {
		// Add your implementation here
		for(int i=0;i<=index;i++)
            remove(i);
	}

	@Override
	public void removeToElement(Student student)throws IllegalArgumentException  {
		// Add your implementation here
		for(int i=0;i<len;i++)
        {
            if(students[i].compareTo(student)==0)
                removeToIndex(i);
        }
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
        for(int i=0;i<len;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                if(students[i].compareTo(students[j])>0)
                {
                    Student temp=new Student();
                    temp.copyFrom(students[i]);
                    students[i].copyFrom(students[j]);
                    students[j].copyFrom(temp);
                }
            }
        }
	}

	@Override
	public Student[] getByBirthDate(Date date)throws IllegalArgumentException {
		// Add your implementation here
		Student[] arr;
		int j=0;

            for(int i=0;i<len;i++)
            {
                if(students[i].birthDate.compareTo(date))
                {
                    arr[j++].copyFrom(students[i]);
                }
            }

		return arr;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate)throws IllegalArgumentException {
		// Add your implementation here
		Student[] arr;
		int j=0;

            for(int i=0;i<len;i++)
            {
                if(students[i].birthDate.compareTo(firstDate) && students[i].birthDatel.compareTo(lastDate))
                {
                    arr[j++].copyFrom(students[i]);
                }
            }

		return arr;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days)throws IllegalArgumentException {
		// Add your implementation here
		Date new=Calender.add(date,days);
		Student[] arr=new Student[];
		int j=0;
		for(int i=0;i<len;i++)
            {
                if(students[i].birthDate.compareTo(date) && students[i].birthDate.compareTo(new))
                {
                    arr[j++].copyFrom(students[i]);
                }
            }
		return arr;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent)throws IllegalArgumentException {
		// Add your implementation here
            return (students[indexOfStudent].getYear()-new Date().getYear());
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		Student[] arr;
		int j=0;
		for(int i=0;i<len;i++)
        {
            if((students[i].getYear()-new Date().getYear())==age)
                arr[j++].copyFrom(students[i]);
        }
		return arr;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		Student[] arr;
		int j=0,max=0;
		for(int i=0;i<len;i++)
        {
            if(students[i].getAvgMark()>max)
                max=students[i].getAvgMark();
        }
        for(int i=0;i<len;i++)
        {
            if(students[i].getAvgMark()==max)
                arr[j++].copyFrom(students[i]);
        }
		return arr;
	}

	@Override
	public Student getNextStudent(Student student) throws IllegaArgumentException{
		// Add your implementation here
		Student arr=new Student();
		for(int i=0;i<len;i++)
        {
            if(students[i].compareTo(student)==0)
            {
                arr.copyFrom(students[i+1]);
            }
        }
		return arr;
	}
}
