package com.acc.dao;

import java.util.List;
import java.util.Map;

import com.acc.model.AccLecture;

public interface AccLectureMapper extends BaseMapper<AccLecture>{

	void update(AccLecture accLecture) throws Exception;
	void delete(Map<String, Object> map) throws Exception;
	List<AccLecture> getLecture(Map<String, Object> map) throws Exception;
}
