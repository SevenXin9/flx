package com.VO;

import com.bean.Authority;

public class AuthorityVo {
    private Authority authority;
    private boolean checked;

    public AuthorityVo() {
    }

    public AuthorityVo(Authority authority, boolean checked) {
        this.authority = authority;
        this.checked = checked;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
