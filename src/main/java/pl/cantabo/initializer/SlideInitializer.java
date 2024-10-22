package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.slide.SlideRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SlideInitializer {

    private final SlideRepository slideRepository;

    public void initialize() {
        // Treść pieśni źródło: https://piesni-religijne.pl

        // Bliskie jest królestwo Boże
        slideRepository.insertSlide(
                UUID.fromString("09d7f388-0d59-48ea-a14b-31350a837b1d"),
                0,
                "<p>Bóg jest Światłością</p><p>I nie ma w Nim żadnej ciemności.</p><p>Jeżeli chodzimy w światłości,</p><p>Wtedy mamy łączność między sobą.</p>",
                true,
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        slideRepository.insertSlide(
                UUID.fromString("a0f4c1cd-ea30-4591-b538-5840ec39b0e3"),
                1,
                "<p>Ref: Bliskie jest królestwo Boże</p><p>Nawracajmy się i wierzmy w Ewangelię.</p>",
                true,
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        slideRepository.insertSlide(
                UUID.fromString("5f8ca146-bf5d-4d2f-b336-0875e435f14d"),
                2,
                "<p>Krew Jezusa, Jego Syna,</p><p>Oczyszcza nas z wszelkiego grzechu.</p><p>Jeżeli mówimy, że nie mamy grzechu,</p><p>To samych siebie oszukujemy.</p>",
                true,
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        slideRepository.insertSlide(
                UUID.fromString("d33552bc-3a4e-4348-b61f-e4dc1aa9db63"),
                3,
                "<p>Ref: Bliskie jest królestwo Boże</p><p>Nawracajmy się i wierzmy w Ewangelię.</p>",
                true,
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        slideRepository.insertSlide(
                UUID.fromString("a4c249d8-90d2-44f4-9546-c06b84c54e5e"),
                4,
                "<p>Jeżeli wyznajemy nasze grzechy,</p><p>Bóg oczyści nas z wszelkiej nieprawości.</p><p>Jeśliby nawet ktoś zgrzeszył,</p><p>Mamy Rzecznika wobec Ojca Jezusa Chrystusa.</p>",
                true,
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        slideRepository.insertSlide(
                UUID.fromString("3d70e996-46d1-4061-a3be-d87db212734d"),
                5,
                "<p>Ref: Bliskie jest królestwo Boże</p><p>Nawracajmy się i wierzmy w Ewangelię.</p>",
                true,
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        // Archanioł Boży Gabriel
        slideRepository.insertSlide(
                UUID.fromString("ee624dd2-618d-430a-a705-12e69bf2def8"),
                0,
                "<p>Archanioł Boży Gabriel,</p><p>Posłan do Panny Maryi,</p><p>Z Majestatu Trójcy Świętej,</p><p>Tak sprawował poselstwo k’Niej</p>",
                true,
                UUID.fromString("21543c8c-6c5e-4fe7-a140-78c0a52470e3")
        );

        slideRepository.insertSlide(
                UUID.fromString("ff6e941f-2aa1-426e-9c55-5074b3bd5ad0"),
                1,
                "<p>Zdrowaś, Panno, łaskiś pełna,</p><p>Pan jest z Tobą, to rzecz pewna.</p>",
                true,
                UUID.fromString("21543c8c-6c5e-4fe7-a140-78c0a52470e3")
        );

        slideRepository.insertSlide(
                UUID.fromString("12805266-6571-4ccc-91f9-e1e97ddc9330"),
                2,
                "<p>Panna się wielce zdumiała</p><p>Z poselstwa, które słyszała;</p><p>Pokorniuchno się skłoniła,</p><p>Jako Panna sromięźliwa,</p>",
                true,
                UUID.fromString("21543c8c-6c5e-4fe7-a140-78c0a52470e3")
        );

        slideRepository.insertSlide(
                UUID.fromString("4a285b33-16e8-4021-8dec-af71721d2067"),
                3,
                "<p>Zdrowaś, Panno, łaskiś pełna,</p><p>Pan jest z Tobą, to rzecz pewna.</p>",
                true,
                UUID.fromString("21543c8c-6c5e-4fe7-a140-78c0a52470e3")
        );

        slideRepository.insertSlide(
                UUID.fromString("98ec08ed-e937-4cd2-8af7-57ebcfaaca0b"),
                4,
                "<p>Ale poseł z wysokości.</p><p>Napełnion Boskiej mądrości,</p><p>Rzekł Jej: „Nie bój się Marya,</p><p>Najszczęśliwszaś Panno miła,</p>",
                true,
                UUID.fromString("21543c8c-6c5e-4fe7-a140-78c0a52470e3")
        );

        // Spuśccie nam na ziemskie niwy
        slideRepository.insertSlide(
                UUID.fromString("ea3b37ba-6a1c-4bb3-8947-41560290930b"),
                0,
                "<p>Spuśćcie nam na ziemskie niwy</p><p>Zbawcę z niebios, obłoki,</p><p>Świat przez grzechy nieszczęśliwy.</p><p>Wołał w nocy głębokiej;</p>",
                true,
                UUID.fromString("71db877c-6d94-40e8-9dbb-d92c80162832")
        );

        slideRepository.insertSlide(
                UUID.fromString("ef8b20d2-1060-4d17-8f8c-3f3b532905a2"),
                1,
                "<p>Gdy wśród przekleństwa od Boga</p><p>Czart panował, śmierć i trwoga,</p><p>A ciężkie przewinienia</p><p>Zamkły bramy zbawienia.</p>",
                true,
                UUID.fromString("71db877c-6d94-40e8-9dbb-d92c80162832")
        );

        slideRepository.insertSlide(
                UUID.fromString("fafb9afc-41c8-4e21-b23a-9c7c3282e5f6"),
                2,
                "<p>Ale się Ojciec zlitował</p><p>nad nędzną ludzi dolą,</p><p>Syn się chętnie ofiarował,</p><p>by spełnił wieczną wolę;</p>",
                true,
                UUID.fromString("71db877c-6d94-40e8-9dbb-d92c80162832")
        );

        slideRepository.insertSlide(
                UUID.fromString("f147ed01-e7eb-443a-bee6-b76b130983a8"),
                3,
                "<p>zaraz Gabryel zstępuje</p><p>i Maryi to zwiastuje,</p><p>iże z Ducha Świętego</p><p>pocznie Syna Bożego.</p>",
                true,
                UUID.fromString("71db877c-6d94-40e8-9dbb-d92c80162832")
        );

        // Wśród nocnej ciszy
        slideRepository.insertSlide(
                UUID.fromString("4a12579c-6d78-45a8-b227-9e9ff80181c1"),
                0,
                "<p>Wśród nocnej ciszy głos się rozchodzi:</p><p>Wstańcie, pasterze, Bóg się wam rodzi</p><p>Czym prędzej się wybierajcie,</p><p>Do Betlejem pośpieszajcie,</p><p>Przywitać Pana.</p>",
                true,
                UUID.fromString("03795b7f-1ffc-4d46-a012-171d63f34d8e")
        );

        slideRepository.insertSlide(
                UUID.fromString("b13370a1-91ac-4f11-86eb-04edc3ab4e65"),
                1,
                "<p>Poszli, znaleźli Dzieciątko w żłobie,</p><p>Z wszystkimi znaki, danymi sobie.</p><p>Jako Bogu cześć Mu dali,</p><p>A witając zawołali,</p><p>Z wielkiej radości.</p>",
                true,
                UUID.fromString("03795b7f-1ffc-4d46-a012-171d63f34d8e")
        );

        slideRepository.insertSlide(
                UUID.fromString("12988016-365f-408d-a8e1-0159a0d64853"),
                2,
                "<p>„Ach witaj, Zbawco; z dawna żądany,</p><p>Tyle tysięcy lat wyglądany!</p><p>Na Ciebie króle, prorocy,</p><p>Czekali, a Tyś tej nocy –</p><p>Nam się objawił”.</p>",
                true,
                UUID.fromString("03795b7f-1ffc-4d46-a012-171d63f34d8e")
        );

        slideRepository.insertSlide(
                UUID.fromString("2c46207e-faf6-480e-8571-703d3a3dc1b7"),
                3,
                "<p>I my czekamy na Ciebie, Pana,</p><p>A skoro przyjdziesz na głos kapłana.</p><p>Padniemy na twarz przed Tobą,</p><p>Wierząc, żeś jest pod osłoną,</p><p>Chleba i wina.</p>",
                true,
                UUID.fromString("03795b7f-1ffc-4d46-a012-171d63f34d8e")
        );

        // Dzisiaj w Betlejem
        slideRepository.insertSlide(
                UUID.fromString("c019513e-1f30-4261-9137-febde493794f"),
                0,
                "<p>Dzisiaj w Betlejem, dzisiaj w Betlejem,</p><p>Wesoła nowina.</p><p>Że Panna czysta, że Panna czysta</p><p>Porodziła Syna.</p>",
                true,
                UUID.fromString("5e66a7cd-4f7a-4f14-a66b-96bde53627d1")
        );

        slideRepository.insertSlide(
                UUID.fromString("1aaa6522-f4f6-4a7b-b41f-56c9a750b17c"),
                1,
                "<p>Chrystus się rodzi,</p><p>nas oswobodzi,</p><p>Anieli grają,</p><p>Króle witają,</p><p>Pasterze śpiewają,</p><p>bydlęta klękają,</p><p>Cuda, cuda ogłaszają.</p>",
                true,
                UUID.fromString("5e66a7cd-4f7a-4f14-a66b-96bde53627d1")
        );

        slideRepository.insertSlide(
                UUID.fromString("abcde123-4567-890a-bcde-f1234567890a"),
                2,
                "<p>Maryja Panna, Maryja Panna,</p><p>Dzieciątko piastuje.</p><p>I Józef święty, I Józef święty,</p><p>Ono pielęgnuje.</p>",
                true,
                UUID.fromString("5e66a7cd-4f7a-4f14-a66b-96bde53627d1")
        );

        slideRepository.insertSlide(
                UUID.fromString("6d3e86f9-d0a9-42cb-a825-364b7771d694"),
                3,
                "<p>Choć w stajeneczce, choć w stajeneczce,</p><p>Panna Syna rodzi,</p><p>Przecież On wkrótce, Przecież On wkrótce,</p><p>Ludzi oswobodzi.</p>",
                true,
                UUID.fromString("5e66a7cd-4f7a-4f14-a66b-96bde53627d1")
        );

        slideRepository.insertSlide(
                UUID.fromString("8870ff52-7165-4960-afd9-28269baa08d8"),
                4,
                "<p>I trzej Królowie, i trzej Królowie,</p><p>Od wschodu przybyli,</p><p>I dary Panu, i dary Panu,</p><p>Kosztowne złożyli.</p>",
                true,
                UUID.fromString("5e66a7cd-4f7a-4f14-a66b-96bde53627d1")
        );

        slideRepository.insertSlide(
                UUID.fromString("b23c3506-82c1-41c3-a979-98fc7c7fff77"),
                5,
                "<p>Pójdźmy też i my, pójdźmy też i my,</p><p>Przywitać Jezusa,</p><p>Króla nad królami, Króla nad królami,</p><p>Uwielbić Chrystusa.</p>",
                true,
                UUID.fromString("5e66a7cd-4f7a-4f14-a66b-96bde53627d1")
        );

        // Przybieżeli do Betlejem pasterze
        slideRepository.insertSlide(
                UUID.fromString("d0692c1f-bb09-4186-86eb-cf33f26639c1"),
                0,
                "<p>Przybieżeli do Betlejem pasterze,</p><p>grając skocznie Dzieciąteczku na lirze.</p><p>Ref: Chwała na wysokości,</p><p>chwała na wysokości,</p><p>a pokój na ziemi.</p>",
                true,
                UUID.fromString("4f6b7d3d-3490-4eb7-a1c5-2c948d8a2c50")
        );

        slideRepository.insertSlide(
                UUID.fromString("4ca2dbf7-dcc7-42ca-8c99-783f235e34ce"),
                1,
                "<p>Oddawali swe ukłony w pokorze</p><p>Tobie, z serca ochotnego, o Boże!</p><p>Ref: Chwała na wysokości,</p><p>chwała na wysokości,</p><p>a pokój na ziemi.</p>",
                true,
                UUID.fromString("4f6b7d3d-3490-4eb7-a1c5-2c948d8a2c50")
        );

        slideRepository.insertSlide(
                UUID.fromString("5214c113-40d1-4dbd-9c67-2766fff16f14"),
                2,
                "<p>Anioł Pański sam ogłosił te dziwy,</p><p>których oni nie słyszeli, jak żywi.</p><p>Ref: Chwała na wysokości,</p><p>chwała na wysokości,</p><p>a pokój na ziemi.</p>",
                true,
                UUID.fromString("4f6b7d3d-3490-4eb7-a1c5-2c948d8a2c50")
        );

        slideRepository.insertSlide(
                UUID.fromString("220cfd8b-9a8a-43ed-bd19-6fc035977c87"),
                3,
                "<p>I Anieli gromadami pilnują,</p><p>Panna czysta wraz z Józefem piastują.</p><p>Ref: Chwała na wysokości,</p><p>chwała na wysokości,</p><p>a pokój na ziemi.</p>",
                true,
                UUID.fromString("4f6b7d3d-3490-4eb7-a1c5-2c948d8a2c50")
        );

        // Bóg się rodzi
        slideRepository.insertSlide(
                UUID.fromString("2d6e3e11-609f-4315-95d5-cc643ca62b4c"),
                0,
                "<p>Bóg się rodzi, moc truchleje:</p><p>Pan niebiosów obnażony.</p><p>Ogień krzepnie, blask ciemnieje,</p><p>Ma granice Nieskończony:</p>",
                true,
                UUID.fromString("1e5dccfd-022b-40d7-87af-5809bdb137a0")
        );

        slideRepository.insertSlide(
                UUID.fromString("93539823-cf4a-4a19-bec8-890d88bb57a7"),
                1,
                "<p>Wzgardzony okryty chwałą,</p><p>Śmiertelny Król nad wiekami;</p><p>A Słowo ciałem się stało</p><p>I mieszkało między nami.</p>",
                true,
                UUID.fromString("1e5dccfd-022b-40d7-87af-5809bdb137a0")
        );

        slideRepository.insertSlide(
                UUID.fromString("cfefe0b0-7519-45bd-8739-aff980ff0653"),
                2,
                "<p>Cóż masz, niebo, nad ziemiami?</p><p>Bóg porzucił szczęście swoje,</p><p>Wszedł między lud ukochany,</p><p>Dzieląc z nim trudy i znoje,</p>",
                true,
                UUID.fromString("1e5dccfd-022b-40d7-87af-5809bdb137a0")
        );

        slideRepository.insertSlide(
                UUID.fromString("c702d02e-d755-4072-90a9-1780eb31fd57"),
                3,
                "<p>Niemało cierpiał, niemało,</p><p>Żeśmy byli winni sami,</p><p>A Słowo ciałem się stało</p><p>I mieszkało między nami.</p>",
                true,
                UUID.fromString("1e5dccfd-022b-40d7-87af-5809bdb137a0")
        );

        slideRepository.insertSlide(
                UUID.fromString("a35f9b62-0c0a-4425-901a-f8f545f47b02"),
                4,
                "<p>W nędznej szopie urodzony,</p><p>Żłób Mu za kolebkę dano.</p><p>Cóż jest, czym był otoczony?</p><p>Bydło, pasterze i siano;</p>",
                true,
                UUID.fromString("1e5dccfd-022b-40d7-87af-5809bdb137a0")
        );

        // Ach mój Jezu
        slideRepository.insertSlide(
                UUID.fromString("84245ef2-7356-4212-8811-6d63f73df663"),
                0,
                "Ach, mój Jezu, jak Ty klęczysz\nW Ogrójcu zakrwawiony!\nTam Cię Anioł w smutku cieszył,\nSkąd był świat pocieszony.",
                true,
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        slideRepository.insertSlide(
                UUID.fromString("0a946fb1-136e-4b11-bd47-2b07d6461e4e"),
                1,
                "Przyjdź, mój Jezu,\nPrzyjdź, mój Jezu,\nPrzyjdź, mój Jezu, pociesz mnie,\nBo Cię kocham serdecznie.",
                true,
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        slideRepository.insertSlide(
                UUID.fromString("0fc9a267-6828-4bc6-9b94-7e7d1e0d2046"),
                2,
                "Ach, mój Jezu, jakeś srodze\nDo słupa przywiązany.\nZa tak ciężkie grzechy nasze\nOkrutnie biczowany.",
                true,
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        slideRepository.insertSlide(
                UUID.fromString("55f070f2-9a92-4e63-86e7-c2a9d547dc71"),
                3,
                "Przyjdź, mój Jezu,\nPrzyjdź, mój Jezu,\nPrzyjdź, mój Jezu, pociesz mnie,\nBo Cię kocham serdecznie.",
                true,
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        slideRepository.insertSlide(
                UUID.fromString("61ce9e14-2fc1-4b89-9a91-08c6e049f784"),
                4,
                "Ach, mój Jezu, co za boleść\nCierpisz w ostrej koronie.\nTwarz najświętsza zakrwawiona,\nGłowa wszystka w krwi tonie.",
                true,
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        slideRepository.insertSlide(
                UUID.fromString("668a0a59-0ae0-4e23-88d1-3b03b5aaf0be"),
                5,
                "Przyjdź, mój Jezu,\nPrzyjdź, mój Jezu,\nPrzyjdź, mój Jezu, pociesz mnie,\nBo Cię kocham serdecznie.",
                true,
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        // Pewnej nocy
        slideRepository.insertSlide(
                UUID.fromString("d2796472-30ab-491e-a0c5-2b2f275645cc"),
                0,
                "Pewnej nocy łzy z oczu mych\notarł dłonią swą Jezus\ni powiedział mi: „Nie martw się,\nJam przy boku jest twym.”",
                true,
                UUID.fromString("b77433fb-2e21-4fef-abff-8e1637456c0e")
        );

        slideRepository.insertSlide(
                UUID.fromString("9ee2bc12-2eee-4acf-b8b4-9b126617ecf7"),
                1,
                "Potem spojrzał na grzeszny świat\npogrążony w ciemności,\ni zwracając się do mnie,\npełen smutku tak rzekł:",
                true,
                UUID.fromString("b77433fb-2e21-4fef-abff-8e1637456c0e")
        );

        slideRepository.insertSlide(
                UUID.fromString("fc8a7c40-0809-4141-aac4-17870b3bf60a"),
                2,
                "Ref.: „Powiedz ludziom, że kocham ich,\nże się o nich wciąż troszczę,.\njeśli zeszli już z moich dróg,\npowiedz, że szukam ich.”(2x)",
                true,
                UUID.fromString("b77433fb-2e21-4fef-abff-8e1637456c0e")
        );

        // Rozpięty na ramionach
        slideRepository.insertSlide(
                UUID.fromString("4e1fbb1b-061e-424c-a1e8-1d25ce44bb68"),
                0,
                "Rozpięty na ramionach\nJak sokół na niebie.\nChrystusie, Synu Boga,\nSpójrz proszę na ziemię.",
                true,
                UUID.fromString("789bd035-b492-4b26-9588-a671fe091d16")
        );

        slideRepository.insertSlide(
                UUID.fromString("3c458198-a9cd-42ed-9cb6-771e3d5da6aa"),
                1,
                "Na ruchliwe ulice,\nZabieganych ludzi.\nGdy noc się już kończy,\nA ranek się budzi.",
                true,
                UUID.fromString("789bd035-b492-4b26-9588-a671fe091d16")
        );

        slideRepository.insertSlide(
                UUID.fromString("cacee787-24ff-49d0-b965-3da87b76bc8a"),
                2,
                "Uśmiechnij się przyjaźnie\nZ wysokiego krzyża.\nDo ciężko pracujących,\nCierpiących na pryczach.",
                true,
                UUID.fromString("789bd035-b492-4b26-9588-a671fe091d16")
        );

        // Nie zna śmierci Pan żywota
        slideRepository.insertSlide(
                UUID.fromString("4f972b86-9c4c-4a34-9651-17c42438c523"),
                0,
                "Nie zna śmierci Pan żywota, chociaż przeszedł przez jéj wrota;\nrozerwała grobu pęta ręka święta. Alleluja.",
                true,
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7")
        );

        slideRepository.insertSlide(
                UUID.fromString("e9249064-c460-4e45-914e-0766922a3889"),
                1,
                "Adamie, twój dług spłacony, okup ludzi dokończony;\nwnijdziesz w niebo z szczęśliwymi dziećmi twymi. Alleluja.",
                true,
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7")
        );

        slideRepository.insertSlide(
                UUID.fromString("78b439fb-4e56-4df6-b24e-855a9f07a370"),
                2,
                "Próżno, żołnierze, strzeżecie, w tym grobie Go nie znajdziecie;\nwstał, przeniknął sklepu mury, Bóg natury. Alleluja.",
                true,
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7")
        );

        slideRepository.insertSlide(
                UUID.fromString("e7e699e9-d2b1-4f61-95db-5b8e8f411db9"),
                3,
                "On znowu na ludzkie plemię i na miłą patrzy ziemię.\nJak drogo dzisiaj przybrana, kosztem Pana! Alleluja.",
                true,
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7")
        );

        slideRepository.insertSlide(
                UUID.fromString("543b9dd2-6315-4786-8f6d-1d13f2b790be"),
                4,
                "Przez Twe święte zmartwychwstanie, z grzechów powstać daj nam, Panie,\npotem z Tobą królowanie. Alleluja, Alleluja.",
                true,
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7")
        );

        // Abba Ojcze
        slideRepository.insertSlide(
                UUID.fromString("a6b09b3b-8bde-4f83-9481-c9e7245f0f68"),
                0,
                "Ty wyzwoliłeś nas Panie\nZ kajdan i samych siebie\nA Chrystus stając się bratem\nNauczył nas wołać do Ciebie:\n\nAbba Ojcze! Abba Ojcze! Abba Ojcze! Abba Ojcze!",
                true,
                UUID.fromString("1a03f4fe-a53a-435c-9a4e-fffc0819cdb0")
        );

        slideRepository.insertSlide(
                UUID.fromString("162a0bcf-86d2-4d18-bdf9-4ff335d4ab4d"),
                1,
                "Bo Kościół jak drzewo życia\nW wieczności zapuszcza korzenie\nPrzenika naszą codzienność\nI pokazuje nam Ciebie\n\nAbba Ojcze! Abba Ojcze! Abba Ojcze! Abba Ojcze!",
                true,
                UUID.fromString("1a03f4fe-a53a-435c-9a4e-fffc0819cdb0")
        );

        slideRepository.insertSlide(
                UUID.fromString("02b1f1f5-272c-4479-86a1-f520933acac7"),
                2,
                "Bóg hojnym Dawcą jest życia\nOn wyswobodził nas od śmierci\nI przygarniając do siebie\nUczynił swoimi dziećmi.\n\nAbba Ojcze! Abba Ojcze! Abba Ojcze! Abba Ojcze",
                true,
                UUID.fromString("1a03f4fe-a53a-435c-9a4e-fffc0819cdb0")
        );

        slideRepository.insertSlide(
                UUID.fromString("e6b8eafa-5b82-42d2-b930-7cfa07e64604"),
                3,
                "Wszyscy jesteśmy braćmi\nJesteśmy jedną rodziną.\nTej prawdy nic już nie zaćmi\nI teraz jest jej godzina.\n\nAbba Ojcze! Abba Ojcze! Abba Ojcze! Abba Ojcze",
                true,
                UUID.fromString("1a03f4fe-a53a-435c-9a4e-fffc0819cdb0")
        );

        // Bądźże pozdrowiona
        slideRepository.insertSlide(
                UUID.fromString("7c49b5ba-5f9a-4788-895b-15cfb5d7df5d"),
                0,
                "<p>Bądźże pozdrowiona, Hostio żywa,</p><p>W której Jezus Chrystus Bóstwo ukrywa!</p>",
                true,
                UUID.fromString("af0b1fe7-6889-4314-8de1-9361b2c78e7e")
        );

        slideRepository.insertSlide(
                UUID.fromString("51ea34df-5a39-4a3d-8012-3cbe31bbb0e6"),
                1,
                "<p>Witaj, Jezu, Synu Maryi,</p><p>Tyś jest Bóg prawdziwy w świętej Hostii!!</p>",
                true,
                UUID.fromString("af0b1fe7-6889-4314-8de1-9361b2c78e7e")
        );

        slideRepository.insertSlide(
                UUID.fromString("a58765f5-0a79-4a16-8213-d37a7d3b6176"),
                2,
                "<p>Bądźże pozdrowione, drzewo żywota!</p><p>Niech kwitnie niewinność, anielska cnota.</p>",
                true,
                UUID.fromString("af0b1fe7-6889-4314-8de1-9361b2c78e7e")
        );

        slideRepository.insertSlide(
                UUID.fromString("f490fcb0-9f4e-4d06-878a-075dededc0fc"),
                3,
                "<p>Bądźże pozdrowiony Baranku Boży!</p><p>Zbaw nas, gdy miecz Pański na złych się sroży!</p>",
                true,
                UUID.fromString("af0b1fe7-6889-4314-8de1-9361b2c78e7e")
        );

        // Wszystko Tobie oddać pragnę
        slideRepository.insertSlide(
                UUID.fromString("0fc21a22-0ebb-4737-9069-d9fbcfa6cd4f"),
                0,
                "<p>Wszystko Tobie oddać pragnę</p><p>i dla Ciebie tylko żyć!</p><p>Chcę Cię Jezu kochać wiernie</p><p>dzieckiem Twoim zawsze być!</p>",
                true,
                UUID.fromString("f127ab80-84ee-4d26-a6ff-573d27b451de")
        );

        slideRepository.insertSlide(
                UUID.fromString("638397c4-a5ab-4048-8376-d28d1a696b31"),
                1,
                "<p>Serce moje weź, niech Twą śpiewa cześć,</p><p>serce moje, duszę moją, Panie Jezu weź!</p>",
                true,
                UUID.fromString("f127ab80-84ee-4d26-a6ff-573d27b451de")
        );

        slideRepository.insertSlide(
                UUID.fromString("a7e9cc6a-e999-47ff-aacb-5ee9aae9d94d"),
                2,
                "<p>Wszystko Tobie oddać pragnę</p><p>od najmłodszych moich lat.</p><p>Pomóż Jezu by mnie nie zwiódł</p><p>pokusami swymi świat.</p>",
                true,
                UUID.fromString("f127ab80-84ee-4d26-a6ff-573d27b451de")
        );

        slideRepository.insertSlide(
                UUID.fromString("a5486f9e-bef4-4c16-bcee-f8d8d660763a"),
                3,
                "<p>Serce moje weź, niech Twą śpiewa cześć,</p><p>serce moje, duszę moją, Panie Jezu weź!</p>",
                true,
                UUID.fromString("f127ab80-84ee-4d26-a6ff-573d27b451de")
        );

        // Psalm 23
        slideRepository.insertSlide(
                UUID.fromString("c06f2be9-2c07-46a6-a4a0-70a4818d8a7d"),
                0,
                "Pan jest moim pasterzem, nie brak mi niczego.\nPozwala mi leżeć na zielonych pastwiskach.\nProwadzi mnie nad wody, gdzie mogę odpocząć:\norzeźwia moją duszę.",
                true,
                UUID.fromString("f4bb4062-dce9-4086-b02c-7c933d8e7745")
        );

        slideRepository.insertSlide(
                UUID.fromString("00d369b7-197e-4b69-af02-3c1c67ef69de"),
                1,
                "Wiedzie mnie po właściwych ścieżkach\nprzez wzgląd na swoje imię.\nChociażbym chodził ciemną doliną,\nzła się nie ulęknę,\nbo Ty jesteś ze mną.",
                true,
                UUID.fromString("f4bb4062-dce9-4086-b02c-7c933d8e7745")
        );

        slideRepository.insertSlide(
                UUID.fromString("e6a2e19c-af70-4001-8b61-96f6b3dd7d6a"),
                2,
                "Twój kij i Twoja laska\nsą tym, co mnie pociesza.\nStół dla mnie zastawiasz\nwobec mych przeciwników;\nnamaszczasz mi głowę olejkiem;\nmój kielich jest przeobfity.",
                true,
                UUID.fromString("f4bb4062-dce9-4086-b02c-7c933d8e7745")
        );

        slideRepository.insertSlide(
                UUID.fromString("cf13c4fb-5d47-4599-bdb7-79b2e5e0cc02"),
                3,
                "Tak, dobroć i łaska pójdą w ślad za mną\nprzez wszystkie dni mego życia\ni zamieszkam w domu Pańskim\npo najdłuższe czasy.",
                true,
                UUID.fromString("f4bb4062-dce9-4086-b02c-7c933d8e7745")
        );
    }
}
