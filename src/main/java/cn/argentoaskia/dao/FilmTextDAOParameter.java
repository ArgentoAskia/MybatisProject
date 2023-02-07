package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmTextOrigin2;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FilmTextDAOParameter {

    // ================== 传递单个参数 ===========================

    /**
     * 单个参数 + 基本类型 | (String) | (包装器)：#{参数名}
     * @param id
     * @return
     */
    FilmTextOrigin2 selectById(Integer id);

    /**
     * 单个参数 + 基本类型 | (String) | (包装器)：#{_parameter}
     * mybatis会生成_parameter来代替每个单参数方法的参数
     * @param filmTitle
     * @return
     */
    List<FilmTextOrigin2> selectByTitle(String filmTitle);

    /**
     * 单个参数 + 实体类(POJO),比如：FilmTextOrigin2：#{实体类的属性（字段名）}，比如：#{title}
     *
     * @param filmTextOrigin2
     * @return
     */
    Integer insert(FilmTextOrigin2 filmTextOrigin2);

    /**
     * 单个参数 + 实体类(POJO)情况下，如果想写符合我们习惯上的写法，如#{实体类对象.字段名的}，则需要指定parameterType属性。
     * 这种写法同时还需要给参数进行@Param命名
     * @param filmTextOrigin2
     * @return
     */
    Integer insert3(@Param("filmTextOrigin2") FilmTextOrigin2 filmTextOrigin2);

    // ====================== 多个参数的写法 ========================
    /**
     * 推荐！！
     * 多个参数 + 基本类型 | (String) | (包装器)：使用@Param给参数命名，Mapper写命名的参数名，如：
     *      #{desc}
     * @param id
     * @param title
     * @param description
     * @return
     */
    Integer delete(@Param("id") Integer id,
                   @Param("title") String title,
                   @Param("desc") String description);

    /**
     * 多个参数 + 基本类型 | (String) | (包装器)：使用paramX(X代表数字，从1开始)命名，如#{param1}
     *  #{param1}：代表方法的第一个参数
     *  #{param2}：代表方法的第二个参数，以此类推
     *
     * @param id
     * @param title
     * @param description
     * @return
     */
    Integer delete2(Integer id,
                    String title,
                    String description);

    /**
     * 多个参数 + 基本类型 | (String) | (包装器)：使用argX(X代表数字，从0开始)命名，如#{arg0}
     *  #{arg0}：代表第一个参数
     *  #{arg1}：代表第二个参数，以此类推
     *
     * @param id
     * @param title
     * @param description
     * @return
     */
    Integer delete3(Integer id,
                    String title,
                    String description);

    /**
     * Map实现传递多个参数：#{Map的key}
     *
     * @param params
     * @return
     */
    Integer insert2(Map<String, Object> params);

    /**
     * 多个参数 + POJO：多参数的方法仍然可用，只不过需要指定具体的属性名（字段名），如方法体：
     *  1.采用@Param("ref")，则在mapper中需要指定：#{ref.title}
     *  2.采用param，则在mapper中需要指定：#{param1.title}
     *  3.采用arg，则在mapper中需要指定：#{arg0.title}
     *
     * @return
     */
    Integer update(FilmTextOrigin2 ref, FilmTextOrigin2 newObj);
    Integer update2(FilmTextOrigin2 ref, FilmTextOrigin2 newObj);
    Integer update3(@Param("ref") FilmTextOrigin2 ref,@Param("newObj") FilmTextOrigin2 newObj);

    /**
     * 多个参数 + POJO + Map组合：和多个参数 + POJO的方式差不多
     *
     * @param ref
     * @param newObj
     * @return
     */
    Integer update4(@Param("ref") Map<String, Object> ref,@Param("newObj") FilmTextOrigin2 newObj);

    /**
     * 多个参数 + 基本类型 + POJO组合：
     *  采用@Param注解即可，注意POJO的使用会涉及到@Param注解里面的名字.属性名,如：#{newObj.title}
     *  也可以采用paramX的形式，同样注意PoJo的ParamX要使用.属性名表示，如：#{param1.title}
     *  也可以采用argX的形式，同样注意PoJo的argX要使用.属性名表示，如：#{arg0.title}
     * @param filmId
     * @param newObject
     * @return
     */
    Integer update5(/*@Param("filmId")*/ Integer filmId,
                    /*@Param("newObj")*/ FilmTextOrigin2 newObject);

}
