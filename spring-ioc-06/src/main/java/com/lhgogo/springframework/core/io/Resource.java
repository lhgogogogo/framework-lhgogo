package com.lhgogo.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-04-03 9:21
 * @version:
 */

public interface Resource {

    /**
     * @param :
     * @return InputStream
     * @author 林辉
     * @description 获取输入流
     * @date 2023/4/3 9:22
     */
    InputStream getInputStream() throws IOException;
}
