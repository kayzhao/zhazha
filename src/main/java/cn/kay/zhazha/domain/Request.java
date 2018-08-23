package cn.kay.zhazha.domain;

import java.io.File;

/**
 * @program: zhazha-tool
 * @package: cn.kay.zhazha.domain
 * @author: kayzhao
 * @create: 2018/8/23
 */
public class Request {
    private File unlockFile;
    private File attendFile;

    public void setUnlockFile(File unlockFile) {
        this.unlockFile = unlockFile;
    }

    public void setAttendFile(File attendFile) {
        this.attendFile = attendFile;
    }

    public File getUnlockFile() {
        return unlockFile;
    }

    public File getAttendFile() {
        return attendFile;
    }
}
