package tw.firemaples.onscreenocr.data.usecase

import tw.firemaples.onscreenocr.data.repo.PreferenceRepository
import javax.inject.Inject

class GetShowTextSelectorOnResultViewUseCase @Inject constructor(
    private val preferenceRepository: PreferenceRepository,
) {
    operator fun invoke() = preferenceRepository.getShowTextSelectionOnResultView()
}
