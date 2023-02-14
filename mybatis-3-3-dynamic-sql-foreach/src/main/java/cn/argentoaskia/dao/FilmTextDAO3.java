package cn.argentoaskia.dao;

import cn.argentoaskia.bean.FilmText;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FilmTextDAO3 {

    // 传递数组
    // 默认可使用的参数：array、arg0。因为不定参数，java会把它当数组处理
    // 也可以使用@Param给参数重命名
    // 当存在多个数组的时候直接使用@Param
    int insertArray1(FilmText ...filmTexts);
    int insertArray2(FilmText[] filmTexts);
    int insertArray3(@Param("filmTexts") FilmText ...filmTexts);

    // 传递列表
    // 默认可使用的参数：arg0, collection, list
    // 也可以使用@Param给参数重命名
    // 当存在多个List的时候直接使用@Param
    int insertList1(List<FilmText> filmTextList);
    int insertList2(List<FilmText> filmTextList);
    // 标记了@Param的也可以使用paramX(X 从1开始)
    int insertList3(@Param("filmTextList")List<FilmText> filmTextList);
    int insertList4(List<FilmText> filmTextList);

    // 传递Map,默认只有单个map时可以使用_parameter，多个map直接使用@Param
    // 也可以直接使用@Param给参数重命名
    // 使用map时，index属性是key，item是value
    int insertMap1(Map<String, FilmText> stringFilmTextMap);
    // 多个Map
    int insertMap2(@Param("stringFilmTextMap1") Map<String, FilmText> stringFilmTextMap,
                   @Param("stringFilmTextMap2")Map<String, FilmText> stringFilmTextMap2);

    // 更加精污的更新
    int update(Map<String, Object> keyValueMap);
}
