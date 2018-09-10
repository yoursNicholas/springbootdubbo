package com.xuzhe.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xuzhe.api.UserService;
import com.xuzhe.entity.UserEntity;
import com.xuzhe.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserJPA userJPA;

    public List<UserEntity> list()
    {
        return userJPA.findAll();
    }

    public Page<UserEntity> getEntryByParams(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                             @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return userJPA.findAll(pageable);
    }

    public List<UserEntity> select()
    {
        return userJPA.findAll();
    }
    public String add()
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("第三方");
        userEntity.setAddress("长沙");
        userEntity.setAge(24);
        userJPA.save(userEntity);
        return "用户信息添加成功";
    }

    /*    @RequestMapping(value = "/delete")
        public String delete(Long userId){
            userJPA.delete(userId);
            return "用户信息删除成功";
        }*/
    public List<UserEntity> age(){
        return userJPA.nativeQuery(22);
    }

    /**
     * 根据条件自定义编写删除SQL
     * @return
     */
    public String deleteWhere()
    {
        userJPA.deleteQuery("admin","123456");
        return "自定义SQL删除数据成功";
    }

    /**
     * 分页查询测试
     * @param page 传入页码，从1开始
     * @return
     */
    public List<UserEntity> cutPage(int page)
    {
        UserEntity user = new UserEntity();
        user.setSize(2);
        user.setSord("desc");
        user.setPage(page);

        //获取排序对象
        Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord()) ? Sort.Direction.ASC : Sort.Direction.DESC;
        //设置排序对象参数
        Sort sort = new Sort(sort_direction, user.getSidx());
        //创建分页对象
        PageRequest pageRequest = new PageRequest(user.getPage() - 1,user.getSize(),sort);
        //执行分页查询
        return userJPA.findAll(pageRequest).getContent();
    }
}
