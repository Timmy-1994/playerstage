package com.playerstage.playerstage;
import java.util.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags="使用者管理")
@RestController
public class UserController {

    @ApiOperation("建立使用者")
    @PostMapping("/users")
    public User create(@RequestBody @Validated User user) {
        return user;
    }

    @ApiOperation("使用者詳情")
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        return new User("bbb", 21, "上海", "aaa@bbb.com");
    }

    @ApiOperation("使用者列表")
    @GetMapping("/users")
    public List<User> list(@ApiParam("檢視第幾頁") @RequestParam int pageIndex,
                           @ApiParam("每頁多少條") @RequestParam int pageSize) {
        List<User> result = new ArrayList<>();
        result.add(new User("aaa", 50, "北京", "aaa@ccc.com"));
        result.add(new User("bbb", 21, "廣州", "aaa@ddd.com"));
        return result;
    }

    @ApiIgnore
    @DeleteMapping("/users/{id}")
    public String deleteById(@PathVariable Long id) {
        return "delete user : " + id;
    }

}
