-- SONG_CATEGORIES

INSERT INTO song_categories (id, name, default_item)
VALUES ('f2cbf45e-54b7-4e56-8a94-d1b118f810d0', 'Adwent', true)
ON CONFLICT DO NOTHING;

INSERT INTO song_categories (id, name, default_item)
VALUES ('6700b4e7-13f0-45c4-b63b-44d446a45a3f', 'Boże Narodzenie', true)
ON CONFLICT DO NOTHING;

INSERT INTO song_categories (id, name, default_item)
VALUES ('5e94c08b-8e9a-4f4d-b4d2-df6658a297c6', 'Wielki Post', true)
ON CONFLICT DO NOTHING;

INSERT INTO song_categories (id, name, default_item)
VALUES ('4d3819e0-d413-4b89-99e1-2679fbd2e792', 'Wielkanoc', true)
ON CONFLICT DO NOTHING;

INSERT INTO song_categories (id, name, default_item)
VALUES ('1684a118-9e33-4f45-8aeb-d3e1b51ef2be', 'Okres zwykły', true)
ON CONFLICT DO NOTHING;

INSERT INTO song_categories (id, name, default_item)
VALUES ('a297e4a4-7a2b-4626-a9a9-1c99db749d6b', 'Psalmy', true)
ON CONFLICT DO NOTHING;



-- PLAYLIST_CATEGORIES

INSERT INTO playlist_categories (id, name, default_item)
VALUES ('f2cbf45e-54b7-4e56-8a94-d1b118f810d0', 'Msza święta', true)
ON CONFLICT DO NOTHING;

INSERT INTO playlist_categories (id, name, default_item)
VALUES ('6700b4e7-13f0-45c4-b63b-44d446a45a3f', 'Rekolekcje', true)
ON CONFLICT DO NOTHING;

INSERT INTO playlist_categories (id, name, default_item)
VALUES ('5e94c08b-8e9a-4f4d-b4d2-df6658a297c6', 'Adoracja', true)
ON CONFLICT DO NOTHING;

INSERT INTO playlist_categories (id, name, default_item)
VALUES ('d2f7f61f-7173-4f72-b07a-64c8af5e5e06', 'Droga Krzyżowa', true)
ON CONFLICT DO NOTHING;

INSERT INTO playlist_categories (id, name, default_item)
VALUES ('4d3819e0-d413-4b89-99e1-2679fbd2e792', 'Kolędy', true)
ON CONFLICT DO NOTHING;



-- PROFILES

INSERT INTO profiles (id, name, active, align, all_big, expanded_list, invert_colors, margin, max_font, max_min, show_empty_slide, show_title, sort_by_used, bg_color, stop_color, tx_color, default_item)
VALUES ('4971c362-55bc-48b8-a80a-e862bf5595fb', 'Domyślny', true, 'CENTER', false, false, false, 1, 20, 7, true, false, false, '#000000', '#000000', '#ffffff', true)
ON CONFLICT DO NOTHING;

-- USERS (hasło: qwQW12!@12)
INSERT INTO users (id, active, email, name, password, user_type, default_item)
VALUES ('b7e2180c-459b-444d-a47a-703cf9ba5ae8', true, 'superadmin@cantabo.pl', 'Super admin', '$2a$10$ZavydPLj7og39pWGFIKc0erCzLgGdxontrcwQ5c492ZcpcjwZa2W6', 'SUPER_ADMINISTRATOR', true)
ON CONFLICT DO NOTHING;

INSERT INTO users (id, active, email, name, password, user_type, default_item)
VALUES ('1b7c849c-a3e5-4b9d-a868-3c64416f04bf', true, 'admin@cantabo.pl', 'Admin', '$2a$10$ZavydPLj7og39pWGFIKc0erCzLgGdxontrcwQ5c492ZcpcjwZa2W6', 'ADMINISTRATOR', true)
ON CONFLICT DO NOTHING;

INSERT INTO users (id, active, email, name, password, user_type, default_item)
VALUES ('feaf1c67-7241-4086-8f1c-a7a60b05af84', true, 'user@cantabo.pl', 'User', '$2a$10$ZavydPLj7og39pWGFIKc0erCzLgGdxontrcwQ5c492ZcpcjwZa2W6', 'USER', true)
ON CONFLICT DO NOTHING;

INSERT INTO users (id, active, email, name, password, user_type, default_item)
VALUES ('aabd811e-97b5-4ed9-9650-242a30b2f119', true, 'szymonpogwizd12@gmail.com', 'Szymon Pogwizd', '$2a$10$ZavydPLj7og39pWGFIKc0erCzLgGdxontrcwQ5c492ZcpcjwZa2W6', 'SUPER_ADMINISTRATOR', true)
ON CONFLICT DO NOTHING;

INSERT INTO users (id, active, email, name, password, user_type, default_item)
VALUES ('4011b8d0-f4d3-42dd-a4be-b2e0dff0f219', true, 'jakubporeba8@gmail.com', 'Jakub Poręba', '$2a$10$ZavydPLj7og39pWGFIKc0erCzLgGdxontrcwQ5c492ZcpcjwZa2W6', 'SUPER_ADMINISTRATOR', true)
ON CONFLICT DO NOTHING;



-- SONGS and SLIDES

INSERT INTO songs (id, name, view_counter, default_item)
VALUES ('dd51c3f7-6716-40ff-af45-d0ae81a7751b', 'Bliskie jest Królestwo Boże', 0, true)
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('09d7f388-0d59-48ea-a14b-31350a837b1d', 0, '<p>Bóg jest Światłością</p><p>I nie ma w Nim żadnej ciemności.</p><p>Jeżeli chodzimy w światłości,</p><p>Wtedy mamy łączność między sobą.</p>', true, 'dd51c3f7-6716-40ff-af45-d0ae81a7751b')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('a0f4c1cd-ea30-4591-b538-5840ec39b0e3', 1, '<p>Ref: Bliskie jest królestwo Boże</p><p>Nawracajmy się i wierzmy w Ewangelię.</p>', true, 'dd51c3f7-6716-40ff-af45-d0ae81a7751b')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('5f8ca146-bf5d-4d2f-b336-0875e435f14d', 2, '<p>Krew Jezusa, Jego Syna,</p><p>Oczyszcza nas z wszelkiego grzechu.</p><p>Jeżeli mówimy, że nie mamy grzechu,</p><p>To samych siebie oszukujemy.</p>', true, 'dd51c3f7-6716-40ff-af45-d0ae81a7751b')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('d33552bc-3a4e-4348-b61f-e4dc1aa9db63', 3, '<p>Ref: Bliskie jest królestwo Boże</p><p>Nawracajmy się i wierzmy w Ewangelię.</p>', true, 'dd51c3f7-6716-40ff-af45-d0ae81a7751b')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('a4c249d8-90d2-44f4-9546-c06b84c54e5e', 4, '<p>Jeżeli wyznajemy nasze grzechy,</p><p>Bóg oczyści nas z wszelkiej nieprawości.</p><p>Jeśliby nawet ktoś zgrzeszył,</p><p>Mamy Rzecznika wobec Ojca Jezusa Chrystusa.</p>', true, 'dd51c3f7-6716-40ff-af45-d0ae81a7751b')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('3d70e996-46d1-4061-a3be-d87db212734d', 5, '<p>Ref: Bliskie jest królestwo Boże</p><p>Nawracajmy się i wierzmy w Ewangelię.</p>', true, 'dd51c3f7-6716-40ff-af45-d0ae81a7751b')
ON CONFLICT DO NOTHING;

--

INSERT INTO songs (id, name, view_counter, default_item)
VALUES ('03785b7f-1ffc-4d46-a012-171d63f34d8e', 'Wśród nocnej ciszy', 0, true)
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('4a12579c-6d78-45a8-b227-9e9ff80181c1', 0, '<p>Wśród nocnej ciszy głos się rozchodzi:</p><p>Wstańcie, pasterze, Bóg się wam rodzi</p><p>Czym prędzej się wybierajcie,</p><p>Do Betlejem pośpieszajcie,</p><p>Przywitać Pana.</p>', true, '03785b7f-1ffc-4d46-a012-171d63f34d8e')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('b13370a1-91ac-4f11-86eb-04edc3ab4e65', 1, '<p>Poszli, znaleźli Dzieciątko w żłobie,</p><p>Z wszystkimi znaki, danymi sobie.</p><p>Jako Bogu cześć Mu dali,</p><p>A witając zawołali,</p><p>Z wielkiej radości.</p>', true, '03785b7f-1ffc-4d46-a012-171d63f34d8e')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('12988016-365f-408d-a8e1-0159a0d64853', 2, '<p>„Ach witaj, Zbawco; z dawna żądany,</p><p>Tyle tysięcy lat wyglądany!</p><p>Na Ciebie króle, prorocy,</p><p>Czekali, a Tyś tej nocy –</p><p>Nam się objawił”.</p>', true, '03785b7f-1ffc-4d46-a012-171d63f34d8e')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('2c46207e-faf6-480e-8571-703d3a3dc1b7', 3, '<p>I my czekamy na Ciebie, Pana,</p><p>A skoro przyjdziesz na głos kapłana.</p><p>Padniemy na twarz przed Tobą,</p><p>Wierząc, żeś jest pod osłoną,</p><p>Chleba i wina.</p>', true, '03785b7f-1ffc-4d46-a012-171d63f34d8e')
ON CONFLICT DO NOTHING;

--

INSERT INTO songs (id, name, view_counter, default_item)
VALUES ('8c9dc5e1-605c-416a-9405-57058c007076', 'Ach, mój Jezu', 0, true)
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('84245ef2-7356-4212-8811-6d63f73df663', 0, 'Ach, mój Jezu, jak Ty klęczysz\nW Ogrójcu zakrwawiony!\nTam Cię Anioł w smutku cieszył,\nSkąd był świat pocieszony.', true, '8c9dc5e1-605c-416a-9405-57058c007076')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('0a946fb1-136e-4b11-bd47-2b07d6461e4e', 1, 'Przyjdź, mój Jezu,\nPrzyjdź, mój Jezu,\nPrzyjdź, mój Jezu, pociesz mnie,\nBo Cię kocham serdecznie.', true, '8c9dc5e1-605c-416a-9405-57058c007076')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('0fc9a267-6828-4bc6-9b94-7e7d1e0d2046', 2, 'Ach, mój Jezu, jakeś srodze\nDo słupa przywiązany.\nZa tak ciężkie grzechy nasze\nOkrutnie biczowany.', true, '8c9dc5e1-605c-416a-9405-57058c007076')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('55f070f2-9a92-4e63-86e7-c2a9d547dc71', 3, 'Przyjdź, mój Jezu,\nPrzyjdź, mój Jezu,\nPrzyjdź, mój Jezu, pociesz mnie,\nBo Cię kocham serdecznie.', true, '8c9dc5e1-605c-416a-9405-57058c007076')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('61ce9e14-2fc1-4b89-9a91-08c6e049f784', 4, 'Ach, mój Jezu, co za boleść\nCierpisz w ostrej koronie.\nTwarz najświętsza zakrwawiona,\nGłowa wszystka w krwi tonie.', true, '8c9dc5e1-605c-416a-9405-57058c007076')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('668a0a59-0ae0-4e23-88d1-3b03b5aaf0be', 5, 'Przyjdź, mój Jezu,\nPrzyjdź, mój Jezu,\nPrzyjdź, mój Jezu, pociesz mnie,\nBo Cię kocham serdecznie.', true, '8c9dc5e1-605c-416a-9405-57058c007076')
ON CONFLICT DO NOTHING;

--

INSERT INTO songs (id, name, view_counter, default_item)
VALUES ('60c81edc-a645-4fa6-9413-e32c71ad96a7', 'Nie zna śmierci Pan żywota', 0, true)
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('4f972b86-9c4c-4a34-9651-17c42438c523', 0, 'Nie zna śmierci Pan żywota, chociaż przeszedł przez jéj wrota;\nrozerwała grobu pęta ręka święta. Alleluja.', true, '60c81edc-a645-4fa6-9413-e32c71ad96a7')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('e9249064-c460-4e45-914e-0766922a3889', 1, 'Adamie, twój dług spłacony, okup ludzi dokończony;\nwnijdziesz w niebo z szczęśliwymi dziećmi twymi. Alleluja.', true, '60c81edc-a645-4fa6-9413-e32c71ad96a7')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('78b439fb-4e56-4df6-b24e-855a9f07a370', 2, 'Próżno, żołnierze, strzeżecie, w tym grobie Go nie znajdziecie;\nwstał, przeniknął sklepu mury, Bóg natury. Alleluja.', true, '60c81edc-a645-4fa6-9413-e32c71ad96a7')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('e7e699e9-d2b1-4f61-95db-5b8e8f411db9', 3, 'On znowu na ludzkie plemię i na miłą patrzy ziemię.\nJak drogo dzisiaj przybrana, kosztem Pana! Alleluja.', true, '60c81edc-a645-4fa6-9413-e32c71ad96a7')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('543b9dd2-6315-4786-8f6d-1d13f2b790be', 4, 'Przez Twe święte zmartwychwstanie, z grzechów powstać daj nam, Panie,\npotem z Tobą królowanie. Alleluja, Alleluja.', true, '60c81edc-a645-4fa6-9413-e32c71ad96a7')
ON CONFLICT DO NOTHING;

--

INSERT INTO songs (id, name, view_counter, default_item)
VALUES ('1a03f4fe-a53a-435c-9a4e-fffc0819cdb0', 'Abba Ojcze', 0, true)
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('a6b09b3b-8bde-4f83-9481-c9e7245f0f68', 0, 'Ty wyzwoliłeś nas Panie\nZ kajdan i samych siebie\nA Chrystus stając się bratem\nNauczył nas wołać do Ciebie:\n\nAbba Ojcze! Abba Ojcze! Abba Ojcze! Abba Ojcze!', true, '1a03f4fe-a53a-435c-9a4e-fffc0819cdb0')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('162a0bcf-86d2-4d18-bdf9-4ff335d4ab4d', 1, 'Bo Kościół jak drzewo życia\nW wieczności zapuszcza korzenie\nPrzenika naszą codzienność\nI pokazuje nam Ciebie\n\nAbba Ojcze! Abba Ojcze! Abba Ojcze! Abba Ojcze!', true, '1a03f4fe-a53a-435c-9a4e-fffc0819cdb0')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('02b1f1f5-272c-4479-86a1-f520933acac7', 2, 'Bóg hojnym Dawcą jest życia\nOn wyswobodził nas od śmierci\nI przygarniając do siebie\nUczynił swoimi dziećmi.\n\nAbba Ojcze! Abba Ojcze! Abba Ojcze! Abba Ojcze', true, '1a03f4fe-a53a-435c-9a4e-fffc0819cdb0')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('e6b8eafa-5b82-42d2-b930-7cfa07e64604', 3, 'Wszyscy jesteśmy braćmi\nJesteśmy jedną rodziną.\nTej prawdy nic już nie zaćmi\nI teraz jest jej godzina.\n\nAbba Ojcze! Abba Ojcze! Abba Ojcze! Abba Ojcze', true, '1a03f4fe-a53a-435c-9a4e-fffc0819cdb0')
ON CONFLICT DO NOTHING;

--

INSERT INTO songs (id, name, view_counter, default_item)
VALUES ('f4bb4062-dce9-4086-b02c-7c933d8e7745', 'Psalm 23', 0, true)
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('c06f2be9-2c07-46a6-a4a0-70a4818d8a7d', 0, 'Pan jest moim pasterzem, nie brak mi niczego.\nPozwala mi leżeć na zielonych pastwiskach.\nProwadzi mnie nad wody, gdzie mogę odpocząć:\norzeźwia moją duszę.', true, 'f4bb4062-dce9-4086-b02c-7c933d8e7745')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('00d369b7-197e-4b69-af02-3c1c67ef69de', 1, 'Wiedzie mnie po właściwych ścieżkach\nprzez wzgląd na swoje imię.\nChociażbym chodził ciemną doliną,\nzła się nie ulęknę,\nbo Ty jesteś ze mną.', true, 'f4bb4062-dce9-4086-b02c-7c933d8e7745')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('e6a2e19c-af70-4001-8b61-96f6b3dd7d6a', 2, 'Twój kij i Twoja laska\nsą tym, co mnie pociesza.\nStół dla mnie zastawiasz\nwobec mych przeciwników;\nnamaszczasz mi głowę olejkiem;\nmój kielich jest przeobfity.', true, 'f4bb4062-dce9-4086-b02c-7c933d8e7745')
ON CONFLICT DO NOTHING;

INSERT INTO slides (id, item_order, body, default_item, song_id)
VALUES ('cf13c4fb-5d47-4599-bdb7-79b2e5e0cc02', 3, 'Tak, dobroć i łaska pójdą w ślad za mną\nprzez wszystkie dni mego życia\ni zamieszkam w domu Pańskim\npo najdłuższe czasy.', true, 'f4bb4062-dce9-4086-b02c-7c933d8e7745')
ON CONFLICT DO NOTHING;



-- SONGS_SONG_CATEGORIES

-- 1. Bliskie jest Królestwo Boże - Adwent
INSERT INTO songs_song_categories (song_id, category_id)
VALUES ('dd51c3f7-6716-40ff-af45-d0ae81a7751b', 'f2cbf45e-54b7-4e56-8a94-d1b118f810d0')
ON CONFLICT DO NOTHING;

-- 2. Wśród nocnej ciszy - Boże Narodzenie
INSERT INTO songs_song_categories (song_id, category_id)
VALUES ('03785b7f-1ffc-4d46-a012-171d63f34d8e', '6700b4e7-13f0-45c4-b63b-44d446a45a3f')
ON CONFLICT DO NOTHING;

-- 3. Ach, mój Jezu - Wielki Post
INSERT INTO songs_song_categories (song_id, category_id)
VALUES ('8c9dc5e1-605c-416a-9405-57058c007076', '5e94c08b-8e9a-4f4d-b4d2-df6658a297c6')
ON CONFLICT DO NOTHING;

-- 4. Nie zna śmierci Pan żywota - Wielkanoc
INSERT INTO songs_song_categories (song_id, category_id)
VALUES ('60c81edc-a645-4fa6-9413-e32c71ad96a7', '4d3819e0-d413-4b89-99e1-2679fbd2e792')
ON CONFLICT DO NOTHING;

-- 5. Abba Ojcze - Okres zwykły
INSERT INTO songs_song_categories (song_id, category_id)
VALUES ('1a03f4fe-a53a-435c-9a4e-fffc0819cdb0', '1684a118-9e33-4f45-8aeb-d3e1b51ef2be')
ON CONFLICT DO NOTHING;

-- 6. Psalm 23 - Psalmy
INSERT INTO songs_song_categories (song_id, category_id)
VALUES ('f4bb4062-dce9-4086-b02c-7c933d8e7745', 'a297e4a4-7a2b-4626-a9a9-1c99db749d6b')
ON CONFLICT DO NOTHING;

