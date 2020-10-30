public class Example implements Interface1,Interface2{
    @Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	//MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		Interface1.print("abc");
    }
    public static void main(String[] args) {
        new Example().log("sfxgs");
        FunctionalInterfaceExample functionalInterface=new FunctionalInterfaceExample(){
            @Override
            public void fun(){
                System.out.println("Inside fun method");
            }};
            FunctionalInterfaceExample functionalInterface1=()->{
                    System.out.println("Inside fun method");
                };
        functionalInterface.fun();
        functionalInterface1.fun();

    }
}