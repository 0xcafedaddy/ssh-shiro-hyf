package com.whitehorse.qingzhi.shiro.interceptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.shiro.aop.AnnotationResolver;
import org.apache.shiro.authz.aop.AnnotationsAuthorizingMethodInterceptor;
import org.apache.shiro.authz.aop.AuthenticatedAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.AuthorizingAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.GuestAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.PermissionAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.RoleAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.UserAnnotationMethodInterceptor;
import org.apache.shiro.spring.aop.SpringAnnotationResolver;

/**
* @author hyf
* @date 2017年4月12日
* @description 
*/
public class MyAopMethodInterceptor extends AnnotationsAuthorizingMethodInterceptor implements MethodInterceptor {

    public MyAopMethodInterceptor() {
        List<AuthorizingAnnotationMethodInterceptor> interceptors =
                new ArrayList<AuthorizingAnnotationMethodInterceptor>(5);

        //use a Spring-specific Annotation resolver - Spring's AnnotationUtils is nicer than the
        //raw JDK resolution process.
        AnnotationResolver resolver = new SpringAnnotationResolver();
        //we can re-use the same resolver instance - it does not retain state:
        interceptors.add(new RoleAnnotationMethodInterceptor(resolver));
        interceptors.add(new MyPermissionAnnotationMethodInterceptor(resolver));
        interceptors.add(new AuthenticatedAnnotationMethodInterceptor(resolver));
        interceptors.add(new UserAnnotationMethodInterceptor(resolver));
        interceptors.add(new GuestAnnotationMethodInterceptor(resolver));

        setMethodInterceptors(interceptors);
    }
    /**
     * Creates a {@link MethodInvocation MethodInvocation} that wraps an
     * {@link org.aopalliance.intercept.MethodInvocation org.aopalliance.intercept.MethodInvocation} instance,
     * enabling Shiro Annotations in <a href="http://aopalliance.sourceforge.net/">AOP Alliance</a> environments
     * (Spring, etc).
     *
     * @param implSpecificMethodInvocation AOP Alliance {@link org.aopalliance.intercept.MethodInvocation MethodInvocation}
     * @return a Shiro {@link MethodInvocation MethodInvocation} instance that wraps the AOP Alliance instance.
     */
    protected org.apache.shiro.aop.MethodInvocation createMethodInvocation(Object implSpecificMethodInvocation) {
        final MethodInvocation mi = (MethodInvocation) implSpecificMethodInvocation;

        return new org.apache.shiro.aop.MethodInvocation() {
            public Method getMethod() {
                return mi.getMethod();
            }

            public Object[] getArguments() {
                return mi.getArguments();
            }

            public String toString() {
                return "Method invocation [" + mi.getMethod() + "]";
            }

            public Object proceed() throws Throwable {
                return mi.proceed();
            }

            public Object getThis() {
                return mi.getThis();
            }
        };
    }

    /**
     * Simply casts the method argument to an
     * {@link org.aopalliance.intercept.MethodInvocation org.aopalliance.intercept.MethodInvocation} and then
     * calls <code>methodInvocation.{@link org.aopalliance.intercept.MethodInvocation#proceed proceed}()</code>
     *
     * @param aopAllianceMethodInvocation the {@link org.aopalliance.intercept.MethodInvocation org.aopalliance.intercept.MethodInvocation}
     * @return the {@link org.aopalliance.intercept.MethodInvocation#proceed() org.aopalliance.intercept.MethodInvocation.proceed()} method call result.
     * @throws Throwable if the underlying AOP Alliance <code>proceed()</code> call throws a <code>Throwable</code>.
     */
    protected Object continueInvocation(Object aopAllianceMethodInvocation) throws Throwable {
        MethodInvocation mi = (MethodInvocation) aopAllianceMethodInvocation;
        return mi.proceed();
    }

    /**
     * Creates a Shiro {@link MethodInvocation MethodInvocation} instance and then immediately calls
     * {@link org.apache.shiro.authz.aop.AuthorizingMethodInterceptor#invoke super.invoke}.
     *
     * @param methodInvocation the AOP Alliance-specific <code>methodInvocation</code> instance.
     * @return the return value from invoking the method invocation.
     * @throws Throwable if the underlying AOP Alliance method invocation throws a <code>Throwable</code>.
     */
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        org.apache.shiro.aop.MethodInvocation mi = createMethodInvocation(methodInvocation);
        return super.invoke(mi);
    }
}
