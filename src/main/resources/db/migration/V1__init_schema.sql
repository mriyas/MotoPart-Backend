-- MotoPart schema (PostgreSQL). Generated to match the extracted API contract.

CREATE TABLE location (
    id            BIGSERIAL PRIMARY KEY,
    location_name VARCHAR(255) NOT NULL
);

CREATE TABLE vehicle_type (
    id         BIGSERIAL PRIMARY KEY,
    type_name  VARCHAR(255) NOT NULL,
    created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE model_year (
    id         BIGSERIAL PRIMARY KEY,
    year       VARCHAR(50) NOT NULL,
    arabic     VARCHAR(100),
    type       VARCHAR(50),
    created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE maker (
    id              BIGSERIAL PRIMARY KEY,
    maker_name      VARCHAR(255) NOT NULL,
    maker_image_url VARCHAR(1024),
    type            VARCHAR(50),
    created_at      TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE model (
    id              BIGSERIAL PRIMARY KEY,
    type            VARCHAR(50),
    year            VARCHAR(50),
    maker_id        VARCHAR(50),
    model_name      VARCHAR(255) NOT NULL,
    model_image_url VARCHAR(1024),
    created_at      TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX idx_model_maker ON model (maker_id);

CREATE TABLE part (
    id               BIGSERIAL PRIMARY KEY,
    type             VARCHAR(50),
    year             VARCHAR(50),
    maker_id         VARCHAR(50),
    model_id         VARCHAR(50),
    part_name        VARCHAR(255) NOT NULL,
    part_image_url   VARCHAR(1024),
    part_description TEXT,
    created_at       TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX idx_part_lookup ON part (maker_id, model_id, year);

CREATE TABLE subpart (
    id                BIGSERIAL PRIMARY KEY,
    type              VARCHAR(50),
    year              VARCHAR(50),
    maker_id          VARCHAR(50),
    model_id          VARCHAR(50),
    part_id           VARCHAR(50),
    subpart_name      VARCHAR(255) NOT NULL,
    subpart_image_url VARCHAR(1024),
    description       TEXT,
    created_at        TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX idx_subpart_lookup ON subpart (maker_id, model_id, year, part_id);

CREATE TABLE app_registration (
    id             BIGSERIAL PRIMARY KEY,
    device_id      VARCHAR(255),
    os_info        VARCHAR(255),
    model_info     VARCHAR(255),
    client_version VARCHAR(100),
    device_token   TEXT,
    created_at     TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE app_user (
    id                BIGSERIAL PRIMARY KEY,
    username          VARCHAR(255),
    mobile            VARCHAR(50),
    hide_phone_number VARCHAR(10) DEFAULT '0',
    email             VARCHAR(255),
    location_id       VARCHAR(50),
    location          VARCHAR(255),
    type              VARCHAR(50),
    doc1              VARCHAR(1024),
    doc2              VARCHAR(1024),
    profile_url       VARCHAR(1024),
    status            VARCHAR(10) DEFAULT '1',
    app_id            VARCHAR(50),
    token             TEXT,
    created_at        TIMESTAMPTZ DEFAULT now(),
    last_updated      TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX idx_user_mobile ON app_user (mobile, app_id);

CREATE TABLE otp (
    id         BIGSERIAL PRIMARY KEY,
    user_phone VARCHAR(50),
    app_id     VARCHAR(50),
    otp_code   VARCHAR(10),
    created_at TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX idx_otp_lookup ON otp (user_phone, app_id, created_at DESC);

CREATE TABLE custom_ad (
    id     BIGSERIAL PRIMARY KEY,
    adurl  VARCHAR(1024),
    status VARCHAR(10) DEFAULT '1',
    outurl VARCHAR(1024)
);

CREATE TABLE suggestion (
    id     BIGSERIAL PRIMARY KEY,
    search VARCHAR(255) NOT NULL
);

CREATE TABLE post (
    id               BIGSERIAL PRIMARY KEY,
    status           VARCHAR(10) DEFAULT '1',
    type             VARCHAR(50),
    year             VARCHAR(50),
    maker_id         VARCHAR(50),
    model_id         VARCHAR(50),
    part_id          VARCHAR(50),
    subpart_id       VARCHAR(50),
    part_number      VARCHAR(255),
    item_tittle      VARCHAR(512),     -- original misspelling preserved
    item_usage       TEXT,
    item_condition   VARCHAR(50),
    item_description  TEXT,
    image_url_1      VARCHAR(1024),
    image_url_2      VARCHAR(1024),
    image_url_3      VARCHAR(1024),
    image_url_4      VARCHAR(1024),
    image_url_5      VARCHAR(1024),
    image_url_6      VARCHAR(1024),
    user_type        VARCHAR(50),
    user_id          VARCHAR(50),
    user_name        VARCHAR(255),
    location_id      VARCHAR(50),
    location         VARCHAR(255),
    price            VARCHAR(50),
    phone_number     VARCHAR(50),
    sell_buy         INTEGER DEFAULT 0,
    maker_name       VARCHAR(255),
    model_name       VARCHAR(255),
    part_name        VARCHAR(255),
    subpart_name     VARCHAR(255),
    created_at       TIMESTAMPTZ DEFAULT now(),
    last_updated     TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX idx_post_filter ON post (maker_id, model_id, year, part_id, subpart_id);
CREATE INDEX idx_post_user ON post (user_id);
