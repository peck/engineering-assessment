package com.moon.mapper;

import com.moon.dto.UserParamDTO;
import com.moon.pojo.User;
import com.moon.vo.pojo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.Date;
import java.util.List;

@CacheConfig(cacheNames = "users")
public interface UserMapper {

    /**
     * 根据姓名模糊查询 用户信息.
     *
     * @Cacheable：配置了findByName函数的返回值将被加入缓存。同时在查询时，会先从缓存中获取，若不存在才再发起对数据库的访问。
     *
     * @param name
     * @return
     */
    @Cacheable
    List<User> findByName(@Param("name") String name);


    /**
     * 根据姓名查询用户.
     *
     * @param name
     * @return
     */
    @Cacheable
    User findByName2(@Param("name") String name);


    /**
     * 新增用户信息.
     *
     * @CachePut：配置于函数上，能够根据参数定义条件来进行缓存，它与@Cacheable不同的是，它每次都会真是调用函数，所以主要用于数据新增和修改操作上。它的参数与@Cacheable类似，具体功能可参考上面对@Cacheable参数的解析
     *
     * @param name
     * @return
     */
    @CachePut
    int insert(@Param("name")String name, @Param("age")Integer age, @Param("createDate")Date createDate);


    /**
     * 新增用户信息
     *
     * @param user
     * @return
     */
    int insertUser(User user);


    /**
     * 选择性新增用户信息
     *
     * @param user
     * @return
     *
     * @author moon  2023/01/30  11:44
     */
    int insertSelective(User user);



    /**
     * 删除用户
     *
     * @CacheEvict：配置于函数上，通常用在删除方法上，用来从缓存中移除相应数据。除了同@Cacheable一样的参数之外，它还有下面两个参数：
     *      allEntries：非必需，默认为false。当为true时，会移除所有数据
     *      beforeInvocation：非必需，默认为false，会在调用方法之后移除数据。当为true时，会在调用方法之前移除数据。
     *
     * @param name
     * @return
     */
    @CacheEvict(beforeInvocation = false)
    int deleteUser(@Param("name")String name);


    /**
     * 更新 User 信息.
     *
     * @param user
     * @return
     */
    int updateUser(User user);


    /**
     * 批量更新
     */
    int updateBatch(@Param("userList") List<User> userList);


    /**
     * 通过 UserParamDTO 查询用户信息.
     *
     *
     * @param paramDTO
     * @return
     */
    List<UserVO> selectUserByParamDTO(@Param("paramDTO") UserParamDTO paramDTO);


}
