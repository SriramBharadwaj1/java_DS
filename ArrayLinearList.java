public class ArrayLinearLIst implements LinearLIst
{
	protected Object [] element;
	protected int size;
	public ArrayLinearList(int intitialCapacity)
	{
		if(initialCapacity<1)
		{
			throw new IllegalArgumentException("initialCapacity must be >=1");
		}
		
		element=new Object[initialCapacity];
	}
	
	
	public ArrayLinearList()
	{
		this(10);
	}

	public boolean isEmpty()
	{
		return size==0;
	}

	public int size()
	{
		return size;
	}

	public static Object [] changeLength(Object [] a, int n, int newLength)
	{
		if(n>newLength)
		{
			throw new IllegalArgumentException("New length too small");
		}

		Object [] newArray=(Object[]) Array.newInstance(a.getClass().getComponentType(),newLength);
	
		System.arraycopy(a,0,newArray,0,n)
	
		return newArray;
	}

	public static Object[] changelength1D(Object [] a, int newLength)
	{
		return changeLength1D(a,a.length,newLength);
	}

	void checkIndex(int index)
	{
		if(index<0 || index>=size)
		{
			throw new INdexOUtOfBoundsException("index = "+ index + " size = " + size);
		}

	}

	public Object get(int index)
	{
		checkIndex(index);
		return element[index];
	}

	public int indexOf(Object theElement)
	{
		for(int i=0i<size;i++)
		{
			if( element[i].equals(theElement))
			{
				return i;	
			}
		}
		
		return -1;
	}

	public Object remove(int index)
	{
		checkIndex(index);
		Object removedElement=element[index];
		for(int i=index+1;i<size;i++)
		{
			element[i-1]=element[i];
		}
		
		element[--size]=null;
		return removedElement;
	}

	public void add(int index, Object theElement)
	{
		if(index<0 || index>size)
		{
			throw new IndexOutofBoundsException("index = "+index+" size= "+ size);
		}
		
		if(size==element.length)
		{
			element=ChangeArrayLength.changelength1D(element,2*size);
		}

		for(int i=size-1; i>=index;i--)
		{
			element[i+1]=element[i];
		}

		element[index]=theElement;
		
		size++;	
	}

	public String toString()
	{
		StringBuffer S=new StringBuffer("[");
		for( int i=0;i<size;i++)
		{
			if(element[i] == null)
			{
				S.append("null, ");
			}
			
			else 
			{
				s.append(element[i].toString() +", ");
			}
			
		}
		
		if(size>0)
		{
			s.delete(s.length()-2,s.length());
		}
		
		s.append("]");
			
		return new String(s);
	}
}