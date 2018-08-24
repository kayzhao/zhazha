package cn.kay.zhazha.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @program: zhazha-tool
 * @package: cn.kay.zhazha.domain
 * @author: kayzhao
 * @create: 2018/8/23
 */
public class RequestObject {
    private MultipartFile unclockFile;
    private MultipartFile attendFile;

    public RequestObject() {
    }

    public MultipartFile getUnclockFile() {
        return unclockFile;
    }

    public MultipartFile getAttendFile() {
        return attendFile;
    }

    public void setUnclockFile(MultipartFile unclockFile) {
        this.unclockFile = unclockFile;
    }

    public void setAttendFile(MultipartFile attendFile) {
        this.attendFile = attendFile;
    }
}
