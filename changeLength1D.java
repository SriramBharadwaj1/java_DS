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