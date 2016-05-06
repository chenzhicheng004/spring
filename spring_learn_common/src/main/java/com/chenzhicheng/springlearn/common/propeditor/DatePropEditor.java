package com.chenzhicheng.springlearn.common.propeditor;

import org.apache.log4j.Logger;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/6.
 */
public class DatePropEditor extends PropertyEditorSupport {

    private Logger logger = Logger.getLogger(DatePropEditor.class);

    private String format = "yyyy-MM-dd";

    @Override
    public void setAsText(String text){
        try {
            Date date = new SimpleDateFormat(format).parse(text);
            this.setValue(date);
        }catch (Exception e){
            this.setValue(new Date());
            logger.warn("text is not correct format for date.set default value :current date" + new SimpleDateFormat(format).format(new Date()));
        }
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
