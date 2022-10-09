package com.crystal.oms.model.media;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Media
{
    protected String title;
    protected Category category;
    protected long cost;

}
