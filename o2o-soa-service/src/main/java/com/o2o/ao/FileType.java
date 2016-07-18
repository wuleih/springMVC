package com.o2o.ao;

public enum FileType {
	/** 徽标(100x100) */
	logo("logo",100,100),
	/** 头像 (120x120)*/
	avatar("avatar",120,120),
	/** 一般文档 */
	files("files",5*1024*1024),
	/** 一般图片 (<500kb)*/
	imgs("imgs",500*1024*1024),
	/** 商品图片(800x800) */
	pplib("pplib",800,800),
	/** 临时文档 */
	temp("temp",50*1024*1024),
	/** 临时文档 */
	defaults("defaults",5*1024*1024),
	/** 需保护文档 */
	security("security",5*1024*1024),
	/** app应用 */
	app("app");
	
	/** 目录名称 */
	private String name;
	/** 宽度(px) */
	private Integer width;
	/** 高度(px) */
	private Integer height;
	/** 最大尺寸(kb) */
	private Integer maxSize;
		
	private FileType(String name) {
        this.name = name;        
    }
	
	private FileType(String name, Integer width, Integer height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }
	
	private FileType(String name, Integer maxSize) {
        this.name = name;
        this.maxSize = maxSize;
    }
	
	private FileType(String name, Integer width, Integer height, Integer maxSize) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.maxSize = maxSize;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
	}
}
